package se.lexicon.springboot_jpa_workshop_week4.dao;

import se.lexicon.springboot_jpa_workshop_week4.entity.AppUser;

import java.util.Collection;

public interface AppUserDao {

    AppUser findById(int id);
    Collection<AppUser>findAll();
    AppUser create(AppUser appUser);
    AppUser update(AppUser appUser);
    void delete(int id);
}
