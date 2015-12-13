package ru.kir.cinema.domain;

import javax.persistence.*;

/**
 * Created by Kirill Zhitelev on 13.12.2015.
 */
@Entity
@Table(name = "films")
public class Film {
    @Id
    @Column(name = "id_films")
    private int id;

    @Column(name = "film_name")
    private String filmName;

    @ManyToOne
    @JoinColumn(name = "director")
    private Person director;

    @ManyToOne
    @JoinColumn(name = "country")
    private Country country;

    @Column(name = "budget")
    private String budget;

    @ManyToOne
    @JoinColumn(name = "genre")
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "actor_1")
    private Person actor_1;

    @ManyToOne
    @JoinColumn(name = "actor_2")
    private Person actor_2;

    @ManyToOne
    @JoinColumn(name = "actor_3")
    private Person actor_3;

    @ManyToOne
    @JoinColumn(name = "actor_4")
    private Person actor_4;

    @Column(name = "estimate")
    private String estimate;

    @Column(name = "description")
    private String description;

    public Film() {
    }

    public int getId() {
        return id;
    }

    public String getFilmName() {
        return filmName;
    }

    public Person getDirector() {
        return director;
    }

    public Country getCountry() {
        return country;
    }

    public String getBudget() {
        return budget;
    }

    public Genre getGenre() {
        return genre;
    }

    public Person getActor_1() {
        return actor_1;
    }

    public Person getActor_2() {
        return actor_2;
    }

    public Person getActor_3() {
        return actor_3;
    }

    public Person getActor_4() {
        return actor_4;
    }

    public String getEstimate() {
        return estimate;
    }

    public String getDescription() {
        return description;
    }
}
