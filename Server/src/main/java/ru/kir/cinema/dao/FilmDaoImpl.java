package ru.kir.cinema.dao;

import org.json.JSONObject;

import static ru.kir.cinema.util.Util.getFilmContent;

/**
 * Created by Kirill Zhitelev on 13.12.2015.
 */
public class FilmDaoImpl implements FilmDao {

    @Override
    public JSONObject getByName(String name) {
        return getFilmContent(name);
    }

    @Override
    public JSONObject getById(Integer id) {
        return getFilmContent(id);
    }
}
