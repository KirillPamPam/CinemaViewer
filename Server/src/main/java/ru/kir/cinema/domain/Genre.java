package ru.kir.cinema.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Kirill Zhitelev on 13.12.2015.
 */
@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @Column(name = "id_genr")
    private int id;

    @Column(name = "genre")
    private String genre;

    @OneToMany(mappedBy = "genre")
    private Set<Film> film;

    public Genre() {
    }

    public Set<Film> getFilm() {
        return film;
    }

    public int getId() {
        return id;
    }

    public String getGenre() {
        return genre;
    }
}
