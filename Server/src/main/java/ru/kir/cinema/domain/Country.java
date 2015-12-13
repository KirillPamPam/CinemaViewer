package ru.kir.cinema.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Kirill Zhitelev on 13.12.2015.
 */
@Entity
@Table(name = "countries")
public class Country {
    @Id
    @Column(name = "id_country")
    private int id;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "country")
    private Set<Film> film;

    public Country() {
    }

    public Set<Film> getFilm() {
        return film;
    }

    public int getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }
}
