package ru.kir.cinema.dao;

import org.json.JSONObject;

/**
 * Created by Kirill Zhitelev on 12.12.2015.
 */
public interface PersonDao {
    JSONObject getByLastName(String lastName);

    JSONObject getByName(String name);

    JSONObject getByFullName(String fullName);

}
