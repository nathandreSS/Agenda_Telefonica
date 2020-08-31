package com.nathan.agenda.boot.agenda_telefonica.jpa_repository.repository.queries;

import com.nathan.agenda.boot.agenda_telefonica.jpa_repository.entity.ContatoEntity;
import com.nathan.agenda.boot.agenda_telefonica.ports.backservices.queries.ContatoRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class ContatoRepositoryImpl extends AbstractRepository<ContatoEntity, Long> implements ContatoRepository {

    public ContatoEntity findByName(String name) {
        try {
            return super.getEntityManager().createQuery("SELECT c FROM ContatoEntity c WHERE c.name = :name", ContatoEntity.class )
                    .setParameter("name", name).getSingleResult();
        } catch(NoResultException e) {
            return null;
        } catch(Error e) {
            throw new Error(e.getMessage());
        }
    }

    public List<ContatoEntity> findAll() {
        return super.getEntityManager().createQuery("SELECT c FROM ContatoEntity c" ).getResultList();
    }
}
