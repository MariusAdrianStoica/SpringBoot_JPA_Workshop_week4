package se.lexicon.springboot_jpa_workshop_week4.dao;


import se.lexicon.springboot_jpa_workshop_week4.entity.Author;

import java.util.Collection;

public interface AuthorDao {

    Author findById(int id);
    Collection<Author> findAll();
    Author create(Author appUser);
    Author update(Author appUser);
    void delete(int id);

}
