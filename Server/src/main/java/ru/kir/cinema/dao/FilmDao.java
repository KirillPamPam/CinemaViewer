package ru.kir.cinema.dao;

import org.json.JSONObject;

/**
 * Created by Kirill Zhitelev on 13.12.2015.
 */
public interface FilmDao {
    JSONObject getByName(String name);

    JSONObject getById(Integer id);
}
