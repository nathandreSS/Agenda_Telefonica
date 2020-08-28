package com.nathan.agenda.boot.agenda_telefonica.jpa_repository.repository.queries;

import com.nathan.agenda.boot.agenda_telefonica.jpa_repository.entity.ContatoEntity;
import com.nathan.agenda.boot.agenda_telefonica.ports.backservices.queries.ContatoRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ContatoRepositoryImpl extends AbstractRepository<ContatoEntity, Long> implements ContatoRepository {


    public ContatoEntity findByName(String name) {
        CriteriaBuilder cb = super.getEntityManager().getCriteriaBuilder();

        CriteriaQuery<ContatoEntity> q = cb.createQuery(ContatoEntity.class);
        Root<ContatoEntity> c = q.from(ContatoEntity.class);
        ParameterExpression<String> p = cb.parameter(String.class);
        q.select(c).where(cb.equal(c.get("name"), p));

        TypedQuery<ContatoEntity> query = super.getEntityManager().createQuery(q);
        query.setParameter(p, name);

        try {
            ContatoEntity contato = query.getSingleResult();
            return contato;
        } catch(NoResultException e) {
            return null;
        }
    }

    public List<ContatoEntity> findAll() {
        return super.getEntityManager().createQuery("SELECT c FROM ContatoEntity c" ).getResultList();
    }
}
