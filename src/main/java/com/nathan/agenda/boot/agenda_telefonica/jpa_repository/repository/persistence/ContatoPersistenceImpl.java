package com.nathan.agenda.boot.agenda_telefonica.jpa_repository.repository.persistence;

import com.nathan.agenda.boot.agenda_telefonica.jpa_repository.entity.ContatoEntity;
import com.nathan.agenda.boot.agenda_telefonica.ports.backservices.modifiers.ContatoPersistence;
import org.springframework.stereotype.Repository;

@Repository
public class ContatoPersistenceImpl extends AbstractPersistence<ContatoEntity, Long> implements ContatoPersistence {}
