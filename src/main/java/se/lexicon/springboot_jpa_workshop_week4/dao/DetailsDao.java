package se.lexicon.springboot_jpa_workshop_week4.dao;

import se.lexicon.springboot_jpa_workshop_week4.entity.AppUser;
import se.lexicon.springboot_jpa_workshop_week4.entity.Details;

import java.util.Collection;

public interface DetailsDao {

    Details findById(int id);
    Collection<Details> findAll();
    Details create(Details details);
    Details update(Details details);
    void delete(int id);
}
