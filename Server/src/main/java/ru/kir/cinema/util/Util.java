package ru.kir.cinema.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.json.JSONObject;
import ru.kir.cinema.domain.*;

import java.util.ArrayList;
import java.util.List;

import static ru.kir.common.CinemaConstants.*;

/**
 * Created by Kirill Zhitelev on 12.12.2015.
 */
public class Util {
    private static SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());

        return configuration.addAnnotatedClass(Person.class)
                .addAnnotatedClass(Position.class)
                .addAnnotatedClass(Film.class)
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(Genre.class)
                .buildSessionFactory(builder.build());
    }

    private static void convertPersonToJson(JSONObject responseObj, List<Person> persons) {
        List<Object> list = new ArrayList<>();

        for (Person person: persons) {
            JSONObject personObj = new JSONObject();
            personObj.put(ID, person.getId());
            personObj.put(FIRST_NAME, person.getFirstName());
            personObj.put(LAST_NAME, person.getLastName());
            personObj.put(FULL_NAME, person.getFullName());
            personObj.put(POSITION, person.getPositionId().getPosition());
            personObj.put(BIOGRAPHY, person.getBiography());
            personObj.put(BIRTHDAY, person.getBirthday());

            list.add(personObj);
        }

        responseObj.put(PERSONS, list);
    }

    public static JSONObject getPersonContent(String propertyName, String content) {
        JSONObject responseObj = new JSONObject();
        Session session = null;
        try {
            session = createSessionFactory().openSession();

            List<Person> persons = (List<Person>) session.createCriteria(Person.class).add(Restrictions.eq(propertyName, content)).list();

            convertPersonToJson(responseObj, persons);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        finally {
            if(session != null) {
                session.close();
            }
        }

        return responseObj;
    }

    private static void convertFilmToJson(JSONObject responseObj, List<Film> films) {
        List<Object> list = new ArrayList<>();
        for (Film film: films) {
            JSONObject filmObj = new JSONObject();
            filmObj.put(ID, film.getId());
            filmObj.put(FILM_NAME, film.getFilmName());
            filmObj.put(COUNTRY, film.getCountryId().getCountry());
            filmObj.put(BUDGET, film.getBudget());
            filmObj.put(GENRE, film.getGenreId().getGenre());
            filmObj.put(DIRECTOR, film.getDirector().getFullName());
            filmObj.put(ACTOR_1, film.getActor_1().getFullName());
            filmObj.put(ACTOR_2, film.getActor_2().getFullName());
            filmObj.put(ACTOR_3, film.getActor_3().getFullName());
            filmObj.put(ACTOR_4, film.getActor_4().getFullName());
            filmObj.put(ESTIMATE, film.getEstimate());
            filmObj.put(DESCRIPTION, film.getDescription());

            list.add(filmObj);
        }

        responseObj.put(FILMS, list);
    }

    private static void convertFilmToJson(JSONObject responseObj, Film film) {
        JSONObject filmObj = new JSONObject();

        filmObj.put(ID, film.getId());
        filmObj.put(FILM_NAME, film.getFilmName());
        filmObj.put(COUNTRY, film.getCountryId().getCountry());
        filmObj.put(BUDGET, film.getBudget());
        filmObj.put(GENRE, film.getGenreId().getGenre());
        filmObj.put(DIRECTOR, film.getDirector().getFullName());
        filmObj.put(ACTOR_1, film.getActor_1().getFullName());
        filmObj.put(ACTOR_2, film.getActor_2().getFullName());
        filmObj.put(ACTOR_3, film.getActor_3().getFullName());
        filmObj.put(ACTOR_4, film.getActor_4().getFullName());
        filmObj.put(ESTIMATE, film.getEstimate());
        filmObj.put(DESCRIPTION, film.getDescription());

        responseObj.put(FILMS, filmObj);
    }

    public static JSONObject getFilmContent(String content) {
        JSONObject responseObj = new JSONObject();
        Session session = null;
        try {
            session = createSessionFactory().openSession();

            List<Film> films = (List<Film>) session.createCriteria(Film.class).add(Restrictions.eq(FILM_NAME, content)).list();

            convertFilmToJson(responseObj, films);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        finally {
            if(session != null) {
                session.close();
            }
        }

        return responseObj;
    }

    public static JSONObject getFilmContent(Integer id) {
        JSONObject responseObj = new JSONObject();
        Session session = null;
        try {
            session = createSessionFactory().openSession();

            Film film = (Film) session.load(Film.class, id);

            convertFilmToJson(responseObj, film);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        finally {
            if(session != null) {
                session.close();
            }
        }

        return responseObj;
    }

}
