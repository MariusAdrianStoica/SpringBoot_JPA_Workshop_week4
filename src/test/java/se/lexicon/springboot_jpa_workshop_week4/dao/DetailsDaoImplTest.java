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
import se.lexicon.springboot_jpa_workshop_week4.entity.Details;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
@AutoConfigureTestEntityManager
@DirtiesContext
public class DetailsDaoImplTest {

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
    DetailsDaoImpl testDetailObject;

    @BeforeEach
    public void setup() {

        Details detailsData1 = new Details("test.test@test.se", "Test", LocalDate.parse("2000-01-01"));
        Details createdDetails1 = tem.persist(detailsData1);

        Details detailsData2 = new Details("test2.test2@test.se", "Test2", LocalDate.parse("2000-01-02"));
        Details createdDetails2 = tem.persist(detailsData2);
    }


    @Test
    public void create() {
        Details detailDataTest = new Details("email@test.se", "test3", LocalDate.parse("2022-12-12"));
        Details createdDetailsTest = testDetailObject.create(detailDataTest);

        assertNotNull(createdDetailsTest);
        assertNotNull(createdDetailsTest.getDetailsId());


    }
}
