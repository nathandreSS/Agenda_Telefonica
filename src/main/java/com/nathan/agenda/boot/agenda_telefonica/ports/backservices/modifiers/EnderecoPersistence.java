package com.nathan.agenda.boot.agenda_telefonica.ports.backservices.modifiers;

import com.nathan.agenda.boot.agenda_telefonica.jpa_repository.entity.EnderecoEntity;

public interface EnderecoPersistence {

    void save(EnderecoEntity endereco);

    void update(EnderecoEntity endereco);

    void delete(Long enderecoId);
}
