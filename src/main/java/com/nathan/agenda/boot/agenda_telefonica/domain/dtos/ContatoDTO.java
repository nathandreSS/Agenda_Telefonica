package com.nathan.agenda.boot.agenda_telefonica.domain.dtos;

import com.nathan.agenda.boot.agenda_telefonica.jpa_repository.entity.ContatoEntity;
import com.nathan.agenda.boot.agenda_telefonica.jpa_repository.entity.TelefoneEntity;

import java.util.List;

public class ContatoDTO {

    private ContatoEntity contatoEntity;

    private List<TelefoneEntity> telefone;

    public ContatoEntity getContatoEntity() {
        return contatoEntity;
    }

    public List<TelefoneEntity> getTelefone() {
        return telefone;
    }
}
