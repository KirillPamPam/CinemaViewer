package ru.kir.cinema.service;

import org.json.JSONObject;
import ru.kir.cinema.dao.PersonDao;
import ru.kir.cinema.dao.PersonDaoImpl;

/**
 * Created by Kirill Zhitelev on 12.12.2015.
 */
public class PersonServiceImpl implements PersonService {
    private PersonDao personDao = new PersonDaoImpl();

    @Override
    public JSONObject getByLastName(String lastName) {
        return personDao.getByLastName(lastName);
    }

    @Override
    public JSONObject getByName(String name) {
        return personDao.getByName(name);
    }

    @Override
    public JSONObject getByFullName(String fullName) {
        return personDao.getByFullName(fullName);
    }
}
