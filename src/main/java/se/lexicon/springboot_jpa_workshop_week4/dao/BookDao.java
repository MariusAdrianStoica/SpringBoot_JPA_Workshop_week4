package se.lexicon.springboot_jpa_workshop_week4.dao;

import se.lexicon.springboot_jpa_workshop_week4.entity.AppUser;
import se.lexicon.springboot_jpa_workshop_week4.entity.Book;

import java.util.Collection;

public interface BookDao {

    Book findById(int id);
    Collection<Book> findAll();
    Book create(Book book);
    Book update(Book book);
    void delete(int id);

}
