package ru.kir.cinema.service;

import org.json.JSONObject;

/**
 * Created by Kirill Zhitelev on 12.12.2015.
 */
public interface PersonService {
    JSONObject getByLastName(String lastName);

    JSONObject getByName(String name);

    JSONObject getByFullName(String fullName);
}
