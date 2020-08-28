package com.nathan.agenda.boot.agenda_telefonica.ports.backservices.queries;

import com.nathan.agenda.boot.agenda_telefonica.jpa_repository.entity.ContatoEntity;

import java.util.List;

public interface ContatoRepository {

    ContatoEntity findById(Long id);

    ContatoEntity findByName(String firstName);

    List<ContatoEntity> findAll();

}
