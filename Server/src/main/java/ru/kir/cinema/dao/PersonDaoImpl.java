package ru.kir.cinema.dao;

import org.json.JSONObject;

import static ru.kir.cinema.util.Util.getPersonContent;
import static ru.kir.common.CinemaConstants.*;

/**
 * Created by Kirill Zhitelev on 12.12.2015.
 */
public class PersonDaoImpl implements PersonDao {

    @Override
    public JSONObject getByLastName(String lastName) {
        return getPersonContent(LAST_NAME, lastName);
    }

    @Override
    public JSONObject getByName(String name) {
        return getPersonContent(FIRST_NAME, name);
    }

    @Override
    public JSONObject getByFullName(String fullName) {
        return getPersonContent(FULL_NAME, fullName);
    }
}
