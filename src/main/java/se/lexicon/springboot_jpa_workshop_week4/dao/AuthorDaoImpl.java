package se.lexicon.springboot_jpa_workshop_week4.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.springboot_jpa_workshop_week4.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class AuthorDaoImpl implements AuthorDao{

    @PersistenceContext
    EntityManager entityManager;
    @Override
    @Transactional(readOnly = true)
    public Author findById(int id) {
        return entityManager.find(Author.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Author> findAll() {
        return entityManager.createQuery("SELECT a FROM Author a", Author.class)
                .getResultList();
    }

    @Override
    @Transactional
    public Author create(Author author) {
        if (author == null)throw new IllegalArgumentException("author was null!");
        entityManager.persist(author);
        return author;
    }

    @Override
    @Transactional
    public Author update(Author author) {
        return entityManager.merge(author);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Author foundAuthor = entityManager.find(Author.class, id);
        if(!foundAuthor.equals(null)) entityManager.remove(foundAuthor);

    }
}
