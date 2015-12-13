package ru.kir.cinema.service;

import ru.kir.cinema.dao.PersonDao;
import ru.kir.cinema.dao.PersonDaoImpl;

/**
 * Created by Kirill Zhitelev on 12.12.2015.
 */
public class PersonServiceImpl implements PersonService {
    private PersonDao personDao = new PersonDaoImpl();

    @Override
    public String getByLastName(String lastName) {
        return personDao.getByLastName(lastName);
    }

    @Override
    public String getByName(String name) {
        return personDao.getByName(name);
    }

    @Override
    public String getByFullName(String fullName) {
        return personDao.getByFullName(fullName);
    }
}
