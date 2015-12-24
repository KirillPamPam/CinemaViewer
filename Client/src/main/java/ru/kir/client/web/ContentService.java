package ru.kir.client.web;

import com.google.gwt.http.client.*;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import ru.kir.client.common.ContentCallback;
import ru.kir.client.pojo.Content;

import java.util.ArrayList;
import java.util.List;

import static ru.kir.common.CinemaConstants.*;

/**
 * Created by Kirill Zhitelev on 14.12.2015.
 */
public class ContentService {
    private static final String PATH = "http://localhost:8080/server/cinema/query";
    private List<Content> contents = new ArrayList<>();

    public void getContent(String pathToContent, final ContentCallback callback) {
        RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(PATH + pathToContent));
        try {
            builder.sendRequest(null, new RequestCallback() {
                @Override
                public void onResponseReceived(Request request, Response response) {
                    if(response.getStatusCode() == 200) {
                        contents.clear();

                        JSONValue jsonValue = JSONParser.parseStrict(response.getText());

                        contents = convertToContent(jsonValue, contents);

                        callback.call(contents);
                    }
                }

                @Override
                public void onError(Request request, Throwable exception) {
                    Window.alert("Sorry, there is no response from server");
                }
            });
        } catch (RequestException e) {
            Window.alert("Sorry, couldn't connect to server, please, try later");
        }
    }

    private List<Content> convertToContent(JSONValue value, List<Content> contents) {
        JSONObject jsonObject = value.isObject();
        JSONArray arrayLastName = jsonObject.get(CONTENT).isObject().get(PERSON_LAST_NAME).isObject().get(PERSONS).isArray();
        JSONArray arrayFirstName = jsonObject.get(CONTENT).isObject().get(PERSON_NAME).isObject().get(PERSONS).isArray();
        JSONArray arrayFullName = jsonObject.get(CONTENT).isObject().get(PERSON_FULLNAME).isObject().get(PERSONS).isArray();
        JSONArray arrayFilmName = jsonObject.get(CONTENT).isObject().get(FILM_NAME1).isObject().get(FILMS).isArray();

        if(arrayLastName.size() != 0) {
            for (int i = 0; i < arrayLastName.size(); i++) {
                Content person = new Content();
                setPersonFields(arrayLastName, person, i);
                contents.add(person);
            }
        }
        else if(arrayFirstName.size() != 0) {
            for (int i = 0; i < arrayFirstName.size(); i++) {
                Content person = new Content();
                setPersonFields(arrayFirstName, person, i);
                contents.add(person);
            }
        }
        else if(arrayFullName.size() != 0) {
            for (int i = 0; i < arrayFullName.size(); i++) {
                Content person = new Content();
                setPersonFields(arrayFullName, person, i);
                contents.add(person);
            }
        }
        else if(arrayFilmName.size() != 0) {
            for (int i = 0; i < arrayFilmName.size(); i++) {
                Content film = new Content();
                setFilmFields(arrayFilmName, film, i);
                contents.add(film);
            }
        }
        return contents;
    }

    private void setPersonFields(JSONArray array, Content person, int index) {
        person.setIdPerson((int) array.get(index).isObject().get(ID).isNumber().doubleValue());
        person.setFirstName(array.get(index).isObject().get(FIRST_NAME).isString().stringValue());
        person.setLastName(array.get(index).isObject().get(LAST_NAME).isString().stringValue());
        person.setFullName(array.get(index).isObject().get(FULL_NAME).isString().stringValue());
        person.setPosition(array.get(index).isObject().get(POSITION).isString().stringValue());
        person.setBiography(array.get(index).isObject().get(BIOGRAPHY).isString().stringValue());
        person.setBirthday(array.get(index).isObject().get(BIRTHDAY).isString().stringValue());
    }

    private void setFilmFields(JSONArray array, Content film, int index) {
        film.setIdFilm((int) array.get(index).isObject().get(ID).isNumber().doubleValue());
        film.setFilmName(array.get(index).isObject().get(FILM_NAME).isString().stringValue());
        film.setDirector(array.get(index).isObject().get(DIRECTOR).isString().stringValue());
        film.setCountry(array.get(index).isObject().get(COUNTRY).isString().stringValue());
        film.setGenre(array.get(index).isObject().get(GENRE).isString().stringValue());
        film.setBudget(array.get(index).isObject().get(BUDGET).isString().stringValue());
        film.setActor_1(array.get(index).isObject().get(ACTOR_1).isString().stringValue());
        film.setActor_2(array.get(index).isObject().get(ACTOR_2).isString().stringValue());
        film.setActor_3(array.get(index).isObject().get(ACTOR_3).isString().stringValue());
        film.setActor_4(array.get(index).isObject().get(ACTOR_4).isString().stringValue());
        film.setEstimate(array.get(index).isObject().get(ESTIMATE).isString().stringValue());
        film.setDescription(array.get(index).isObject().get(DESCRIPTION).isString().stringValue());
    }
}
