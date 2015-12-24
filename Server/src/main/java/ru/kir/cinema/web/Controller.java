package ru.kir.cinema.web;

import org.json.JSONObject;
import ru.kir.cinema.service.FilmService;
import ru.kir.cinema.service.FilmServiceImpl;
import ru.kir.cinema.service.PersonService;
import ru.kir.cinema.service.PersonServiceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import static ru.kir.common.CinemaConstants.*;

/**
 * Created by Kirill Zhitelev on 12.12.2015.
 */
@Path("/query")
public class Controller {
    private PersonService personService = new PersonServiceImpl();
    private FilmService filmService = new FilmServiceImpl();

    @Path("{content}")
    @GET
    @Produces("application/json")
    public String getContent(@PathParam("content") String content) {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put(PERSON_LAST_NAME, personService.getByLastName(content));
        jsonObject.put(PERSON_NAME, personService.getByName(content));
        jsonObject.put(PERSON_FULLNAME, personService.getByFullName(content));
        jsonObject.put(FILM_NAME1, filmService.getByName(content));

        return new JSONObject().put(CONTENT, jsonObject).toString();
    }

}
