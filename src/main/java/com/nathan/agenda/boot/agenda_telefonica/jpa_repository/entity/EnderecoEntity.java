package com.nathan.agenda.boot.agenda_telefonica.jpa_repository.entity;

import com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.endereco.Endereco;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ENDERECO")
public class EnderecoEntity extends AbstractEntity<Long> {

    @Column(name = "cep")
    private String cep;

    @Column(name = "numero")
    private int numero;

    @Column(name = "complemento")
    private String complemento;

    public EnderecoEntity(String cep, int numero, String complemento) {
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
    }

    public EnderecoEntity(Endereco endereco) {
        this.cep = endereco.getCep();
        this.numero = endereco.getNumero();
        this.complemento = endereco.getComplemento();
    }

    public EnderecoEntity() {}

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
