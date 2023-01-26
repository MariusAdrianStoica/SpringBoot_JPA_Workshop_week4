package se.lexicon.springboot_jpa_workshop_week4.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.springboot_jpa_workshop_week4.entity.Details;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class DetailsDaoImpl implements DetailsDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public Details findById(int id) {
        return entityManager.find(Details.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Details> findAll() {
        return entityManager.createQuery("SELECT d FROM Details d", Details.class)
                .getResultList();
    }

    @Override
    @Transactional
    public Details create(Details details) {
        if (details == null)throw new IllegalArgumentException("details was null!");
        entityManager.persist(details);
        return details;
    }

    @Override
    @Transactional
    public Details update(Details details) {
        return entityManager.merge(details);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Details foundDetails = entityManager.find(Details.class, id);
        if(foundDetails != null) entityManager.remove(foundDetails);

    }
}
