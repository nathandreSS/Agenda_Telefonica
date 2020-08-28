package com.nathan.agenda.boot.agenda_telefonica.ports.backservices.queries;

import com.nathan.agenda.boot.agenda_telefonica.jpa_repository.entity.TelefoneEntity;

import java.util.List;

public interface TelefoneRepository {
    TelefoneEntity findById(Long id);

    List<TelefoneEntity> findAll();

    List<TelefoneEntity> findByContact(Long contatoId);
}
