package ru.kir.cinema.dao;

/**
 * Created by Kirill Zhitelev on 12.12.2015.
 */
public interface PersonDao {
    String getByLastName(String lastName);

    String getByName(String name);

    String getByFullName(String fullName);

}
