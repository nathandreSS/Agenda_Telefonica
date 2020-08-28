package com.nathan.agenda.boot.agenda_telefonica.jpa_repository.repository.queries;

import com.nathan.agenda.boot.agenda_telefonica.jpa_repository.entity.TelefoneEntity;
import com.nathan.agenda.boot.agenda_telefonica.ports.backservices.queries.TelefoneRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TelefoneRepositoryImpl extends AbstractRepository<TelefoneEntity, Long> implements TelefoneRepository {

    public List<TelefoneEntity> findByContact(Long contatoId) {
        return super.getEntityManager().createQuery("SELECT t.numero FROM TelefoneEntity t WHERE t.contato.id = :contatoId ")
                .setParameter("contatoId", contatoId).getResultList();
    }
}
