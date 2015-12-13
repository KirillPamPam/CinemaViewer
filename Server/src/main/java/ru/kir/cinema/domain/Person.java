package ru.kir.cinema.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Kirill Zhitelev on 12.12.2015.
 */
@Entity
@Table(name = "persons")
public class Person {
    @Id
    @Column(name = "id_person")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "full_name")
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "position")
    private Position position;

    @Column(name = "biography")
    private String biography;

    @Column(name = "birthday")
    private String birthday;

    @OneToMany()
    private Set<Film> film;

    public Person() {
    }

    public int getId() {
        return id;
    }

    public Set<Film> getFilm() {
        return film;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public Position getPositionId() {
        return position;
    }

    public String getBiography() {
        return biography;
    }

    public String getBirthday() {
        return birthday;
    }
}
