package com.nathan.agenda.boot.agenda_telefonica.jpa_repository.entity;

import com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.endereco.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ENDERECO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoEntity extends AbstractEntity<Long> {

    @Column(name = "cep")
    private String cep;

    @Column(name = "numero")
    private int numero;

    @Column(name = "complemento")
    private String complemento;

    public EnderecoEntity(Endereco endereco) {
        this.cep = endereco.getCep();
        this.numero = endereco.getNumero();
        this.complemento = endereco.getComplemento();
    }

    @Override
    public Long getId() {
        return super.getId();
    }
}
