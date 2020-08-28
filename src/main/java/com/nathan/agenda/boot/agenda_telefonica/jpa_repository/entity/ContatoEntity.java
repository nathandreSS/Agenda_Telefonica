package com.nathan.agenda.boot.agenda_telefonica.jpa_repository.entity;

import com.nathan.agenda.boot.agenda_telefonica.domain.Contato;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CONTATO")
@Getter
@Setter
@NoArgsConstructor
public class ContatoEntity extends AbstractEntity<Long>{

    @Column(name = "name", unique = true)
    private String name;

    @OneToMany(mappedBy = "contato")
    private List<TelefoneEntity> telefone = new ArrayList<TelefoneEntity>();

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id_fk")
    private EnderecoEntity endereco;

    public ContatoEntity(String firstName, String lastName, List<TelefoneEntity> telefone, String email, EnderecoEntity endereco) {
        this.name = firstName + " " + lastName;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public ContatoEntity(Contato contato) {
        this.name = contato.getNomeObject().getFirstName() + " " + contato.getNomeObject().getLastName();

        for(int i = 0; i < contato.getTelefoneObject().size(); i++) {
            this.telefone.add(new TelefoneEntity(contato.getTelefoneObject().get(i)));
        }

        this.email = contato.getEmailObject().getEmail();
        this.endereco = new EnderecoEntity(contato.getEnderecoObject());
    }

    public ContatoEntity(Contato contato, Long id) {
        this.id = id;
        this.name = contato.getNomeObject().getFirstName() + " " + contato.getNomeObject().getLastName();

        for(int i = 0; i < contato.getTelefoneObject().size(); i++) {
            this.telefone.add(new TelefoneEntity(contato.getTelefoneObject().get(i)));
        }

        this.email = contato.getEmailObject().getEmail();
        this.endereco = new EnderecoEntity(contato.getEnderecoObject());
    }
}
