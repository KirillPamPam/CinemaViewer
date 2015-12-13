package ru.kir.cinema.service;

import ru.kir.cinema.dao.FilmDao;
import ru.kir.cinema.dao.FilmDaoImpl;

/**
 * Created by Kirill Zhitelev on 13.12.2015.
 */
public class FilmServiceImpl implements FilmService {
    private FilmDao filmDao = new FilmDaoImpl();

    @Override
    public String getByName(String name) {
        return filmDao.getByName(name);
    }
}
