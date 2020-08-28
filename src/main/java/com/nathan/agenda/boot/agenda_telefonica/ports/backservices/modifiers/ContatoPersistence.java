package com.nathan.agenda.boot.agenda_telefonica.ports.backservices.modifiers;

import com.nathan.agenda.boot.agenda_telefonica.jpa_repository.entity.ContatoEntity;

public interface ContatoPersistence {

    void save(ContatoEntity contato);

    void update(ContatoEntity contato);

    void delete(Long contatoId);
}
