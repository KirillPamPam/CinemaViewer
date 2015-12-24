package ru.kir.cinema.service;

import org.json.JSONObject;

/**
 * Created by Kirill Zhitelev on 13.12.2015.
 */
public interface FilmService {
    JSONObject getByName(String name);

    JSONObject getById(Integer id);
}
