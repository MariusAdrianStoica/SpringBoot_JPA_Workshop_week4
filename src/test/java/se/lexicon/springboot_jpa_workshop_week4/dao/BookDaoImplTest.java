package se.lexicon.springboot_jpa_workshop_week4.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.springboot_jpa_workshop_week4.entity.AppUser;
import se.lexicon.springboot_jpa_workshop_week4.entity.Book;
import se.lexicon.springboot_jpa_workshop_week4.entity.Details;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
@AutoConfigureTestEntityManager
@DirtiesContext
public class BookDaoImplTest {

    //step1: create resources directory in test
    //step2: copy application properties from H2
    //step3: @SpringBootTest in from of the class
    //step4: @AutoConfigureTestDatabase -> to use a temp DB and not our original SqL DB
    //step5: @Transactional -> each method has one transaction
    //step6: @AutoConfigureTestEntityManager -> provides functionalities
    //step7: @DirtiesContext - to remove temp DB at the end of the test

    @Autowired
    TestEntityManager tem;
    @Autowired
    BookDaoImpl testObject;


    int bookId1;
    int bookId2;

    @BeforeEach
    public void setup() {

        Book bookData1 = new Book("123456-fdhnio-test", "Book1", 30);
        Book createdBook1 = tem.persist(bookData1);
        bookId1= createdBook1.getBookId();

        Book bookData2 = new Book("654321-jdfiu-test2", "Book2", 45);
        Book createdBook2 = tem.persist(bookData2);
        bookId2= createdBook1.getBookId();

    }


    @Test
    public void create() {

        Book bookDataTest = new Book("987654-tset-test3", "Book3", 15);
        Book createdBookTest = testObject.create(bookDataTest);

        assertNotNull(createdBookTest);
        assertNotNull(createdBookTest.getBookId());

    }


}
