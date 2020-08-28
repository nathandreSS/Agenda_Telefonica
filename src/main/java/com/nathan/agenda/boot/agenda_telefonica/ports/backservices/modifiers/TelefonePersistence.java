package com.nathan.agenda.boot.agenda_telefonica.ports.backservices.modifiers;

import com.nathan.agenda.boot.agenda_telefonica.jpa_repository.entity.TelefoneEntity;

public interface TelefonePersistence {

    void save(TelefoneEntity telefone);

    void update(TelefoneEntity telefone);

    void delete(Long enderecoId);
}
