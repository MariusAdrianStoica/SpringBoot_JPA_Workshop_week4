package se.lexicon.springboot_jpa_workshop_week4.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.springboot_jpa_workshop_week4.entity.AppUser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Optional;

@Repository
public class AppUserDaoImpl implements AppUserDao{

    @PersistenceContext
    EntityManager entityManager;
    @Override
    @Transactional(readOnly = true)
    public AppUser findById(int id) {
        return entityManager.find(AppUser.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<AppUser> findAll() {
        return entityManager.createQuery("SELECT a FROM AppUser A ", AppUser.class)
                .getResultList();
    }

    @Override
    @Transactional
    public AppUser create(AppUser appUser) {
        if (appUser == null)throw new IllegalArgumentException("appUser was null!");
        entityManager.persist(appUser);
        return appUser;
    }

    @Override
    @Transactional
    public AppUser update(AppUser appUser) {
        return entityManager.merge(appUser);
    }

    @Override
    @Transactional
    public void delete(int id) {
        AppUser foundAppUser = entityManager.find(AppUser.class, id);
        if (foundAppUser!= null) entityManager.remove(foundAppUser);


    }
}
