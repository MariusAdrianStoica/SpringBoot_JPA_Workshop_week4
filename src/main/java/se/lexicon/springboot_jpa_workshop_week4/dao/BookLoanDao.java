package se.lexicon.springboot_jpa_workshop_week4.dao;

import se.lexicon.springboot_jpa_workshop_week4.entity.BookLoan;

import java.util.Collection;

public interface BookLoanDao {

    BookLoan findById(int id);
    Collection<BookLoan> findAll();
    BookLoan create(BookLoan bookLoan);
    BookLoan update(BookLoan bookLoan);
    void delete(int id);
}
