package se.lexicon.springboot_jpa_workshop_week4.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int authorId;

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;

    private Set<Book> writtenBooks;

}
