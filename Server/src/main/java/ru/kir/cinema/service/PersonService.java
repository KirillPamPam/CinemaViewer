package ru.kir.cinema.service;

/**
 * Created by Kirill Zhitelev on 12.12.2015.
 */
public interface PersonService {
    String getByLastName(String lastName);

    String getByName(String name);

    String getByFullName(String fullName);
}
