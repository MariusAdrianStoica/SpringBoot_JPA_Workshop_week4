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

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
@AutoConfigureTestEntityManager
@DirtiesContext
public class AppUserDaoImplTest {

    //step1: create resources directory in test
    //step2: copy application properties from H2
    //step3: @SpringBootTest in from of the class
    //step4: @AutoConfigureTestDatabase -> to use a temp DB and not our original SqL DB
    //step5: @Transactional -> each method has one transaction
    //step6: @AutoConfigureTestEntityManager -> provides functionalities
    //step7: @DirtiesContext - to remove temp DB at the end of the test

    @Autowired
    TestEntityManager em;
    @Autowired
    AppUserDaoImpl testObject;
    @Autowired
    DetailsDaoImpl testDetailObject;

    int appUserId;

    @BeforeEach
    public void setup(){

        Details detailsData = new Details("test.test@test.se", "Test", LocalDate.parse("2000-01-01"));
        Details createdDetails =em.persist(detailsData);

        AppUser appUserData = new AppUser("marius.stoica", "password");
        appUserData.setDetails(createdDetails);

        AppUser createdAppUser =em.persist(appUserData);
        appUserId = createdAppUser.getAppUserId();
    }


    /*
@Test
public void create(){
        AppUser appUserDataTest = new AppUser("test.test", "password");

        AppUser createdAppUserTest = testObject.create(appUserDataTest);

        assertNotNull(createdAppUserTest);
        assertNotNull(createdAppUserTest.getAppUserId());


}



     */

}
