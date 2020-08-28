package com.nathan.agenda.boot.agenda_telefonica.jpa_repository.repository.persistence;

import com.nathan.agenda.boot.agenda_telefonica.jpa_repository.entity.TelefoneEntity;
import com.nathan.agenda.boot.agenda_telefonica.ports.backservices.modifiers.TelefonePersistence;
import org.springframework.stereotype.Repository;

@Repository
public class TelefonePersistenceImpl extends AbstractPersistence<TelefoneEntity, Long> implements TelefonePersistence {
}
