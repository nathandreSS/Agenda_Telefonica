package com.nathan.agenda.boot.agenda_telefonica.jpa_repository.repository.persistence;

import com.nathan.agenda.boot.agenda_telefonica.jpa_repository.entity.EnderecoEntity;
import com.nathan.agenda.boot.agenda_telefonica.ports.backservices.modifiers.EnderecoPersistence;
import org.springframework.stereotype.Repository;

@Repository
public class EnderecoPersistenceImpl extends AbstractPersistence<EnderecoEntity, Long> implements EnderecoPersistence {
}
