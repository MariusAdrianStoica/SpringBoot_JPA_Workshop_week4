package se.lexicon.springboot_jpa_workshop_week4.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.springboot_jpa_workshop_week4.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class BookDaoImpl implements BookDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public Book findById(int id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Book> findAll() {
        return entityManager.createQuery("SELECT b FROM Book b", Book.class)
                .getResultList();
    }

    @Override
    @Transactional
    public Book create(Book book) {
        if (book.equals(null))throw new IllegalArgumentException("Book was null");
        entityManager.persist(book);
        return book;
    }

    @Override
    @Transactional
    public Book update(Book book) {
        return entityManager.merge(book);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Book foundBook = entityManager.find(Book.class, id);
        if (!foundBook.equals(null)) entityManager.remove(foundBook);
    }
}
