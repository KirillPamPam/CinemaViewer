package ru.kir.cinema.dao;

import static ru.kir.cinema.util.Util.getFilmContent;

/**
 * Created by Kirill Zhitelev on 13.12.2015.
 */
public class FilmDaoImpl implements FilmDao {

    @Override
    public String getByName(String name) {
        return getFilmContent(name);
    }
}
