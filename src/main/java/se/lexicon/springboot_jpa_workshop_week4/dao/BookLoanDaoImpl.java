package se.lexicon.springboot_jpa_workshop_week4.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.springboot_jpa_workshop_week4.entity.AppUser;
import se.lexicon.springboot_jpa_workshop_week4.entity.BookLoan;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class BookLoanDaoImpl implements BookLoanDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public BookLoan findById(int id) {
        return entityManager.find(BookLoan.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<BookLoan> findAll() {
        return entityManager.createQuery("SELECT bl FROM BookLoan BL", BookLoan.class)
                .getResultList();
    }

    @Override
    @Transactional
    public BookLoan create(BookLoan bookLoan) {
        if (bookLoan.equals(null))throw new IllegalArgumentException("BookLoan was null!");
        entityManager.persist(bookLoan);
        return bookLoan;
    }

    @Override
    @Transactional
    public BookLoan update(BookLoan bookLoan) {
        return entityManager.merge(bookLoan);
    }

    @Override
    @Transactional
    public void delete(int id) {

        BookLoan foundBookLoan = entityManager.find(BookLoan.class, id);
        if (!foundBookLoan.equals(null)) entityManager.remove(foundBookLoan);

    }
}
