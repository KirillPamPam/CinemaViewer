package ru.kir.cinema.service;

import org.json.JSONObject;
import ru.kir.cinema.dao.FilmDao;
import ru.kir.cinema.dao.FilmDaoImpl;

/**
 * Created by Kirill Zhitelev on 13.12.2015.
 */
public class FilmServiceImpl implements FilmService {
    private FilmDao filmDao = new FilmDaoImpl();

    @Override
    public JSONObject getByName(String name) {
        return filmDao.getByName(name);
    }

    @Override
    public JSONObject getById(Integer id) {
        return filmDao.getById(id);
    }
}
