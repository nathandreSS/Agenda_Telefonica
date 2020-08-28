package com.nathan.agenda.boot.agenda_telefonica.ports.backservices.queries;

import com.nathan.agenda.boot.agenda_telefonica.jpa_repository.entity.EnderecoEntity;

import java.util.List;

public interface EnderecoRepository {

    EnderecoEntity findById(Long id);

    List<EnderecoEntity> findAll();
}
