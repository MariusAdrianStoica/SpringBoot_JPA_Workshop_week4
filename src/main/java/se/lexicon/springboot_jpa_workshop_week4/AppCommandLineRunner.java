package se.lexicon.springboot_jpa_workshop_week4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.springboot_jpa_workshop_week4.dao.AppUserDao;
import se.lexicon.springboot_jpa_workshop_week4.dao.DetailsDao;
import se.lexicon.springboot_jpa_workshop_week4.entity.AppUser;
import se.lexicon.springboot_jpa_workshop_week4.entity.Details;

import java.time.LocalDate;

@Component
public class AppCommandLineRunner implements CommandLineRunner {


    @Autowired
    AppUserDao appUserDao;

    @Autowired
    DetailsDao detailsDao;

    @Override
    public void run(String... args) throws Exception {

        /*
        System.out.println("\n##### SpringBoot_JPA_Workshop #####\n");
        Details createdDetails = detailsDao.create(new Details("user1@test.se", "Test", LocalDate.parse("2020-01-01")));
        System.out.println("Created Details: " + createdDetails);
        System.out.println();

        AppUser createdAppuser = appUserDao.create(new AppUser("test.test", "pass"));
        createdAppuser.setDetails(createdDetails);

        System.out.println("Created AppUser: " + createdAppuser);
        System.out.println("\n##### SpringBoot_JPA_Workshop #####\n");

*/
    }
}
