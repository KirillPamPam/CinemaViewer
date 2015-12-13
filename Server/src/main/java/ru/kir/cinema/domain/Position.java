package ru.kir.cinema.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Kirill Zhitelev on 13.12.2015.
 */
@Entity
@Table(name = "positions")
public class Position {
    @Id
    @GeneratedValue
    @Column(name = "id_position")
    private int id;

    @Column(name = "position")
    private String position;

    @OneToMany(mappedBy = "position")
    private Set<Person> person;

    public Position() {
    }

    public Set<Person> getPerson() {
        return person;
    }

    public int getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }
}
