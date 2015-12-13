package ru.kir.cinema.web;

import ru.kir.cinema.service.FilmService;
import ru.kir.cinema.service.FilmServiceImpl;
import ru.kir.cinema.service.PersonService;
import ru.kir.cinema.service.PersonServiceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

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
        List<String> contents = new ArrayList<>();

        contents.add(personService.getByLastName(content));
        contents.add(personService.getByName(content));
        contents.add(personService.getByFullName(content));
        contents.add(filmService.getByName(content));

        return contents.toString();
    }

}
