package com.nathan.agenda.boot.agenda_telefonica.jpa_repository.entity;


import com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.telefone.Telefone;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TELEFONE")
public class TelefoneEntity extends AbstractEntity<Long> {

    @Column(name = "numero")
    private String numero;

    @ManyToOne
    @JoinColumn(name = "contato_id")
    private ContatoEntity contato;

    public TelefoneEntity(String numero) {
        this.numero = numero;
    }

    public TelefoneEntity(Telefone telefone) {
        this.numero = telefone.getTelefone();
    }

    public TelefoneEntity(Long id, Telefone telefone, ContatoEntity contato) {
        this.id = id;
        this.numero = telefone.getTelefone();
        this.contato = contato;
    }

    public TelefoneEntity(Telefone telefone, ContatoEntity contato) {
        this.numero = telefone.getTelefone();
        this.contato = contato;
    }
}
