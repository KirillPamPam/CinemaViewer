package ru.kir.client.pojo;

/**
 * Created by Kirill Zhitelev on 14.12.2015.
 */
public class Content {
    private int idFilm, idPerson;
    private String filmName = null, director = null, country = null, budget = null, genre, actor_1, actor_2, actor_3, actor_4, estimate, description;
    private String firstName, lastName, fullName, position, biography, birthday;

    public Content() {

    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getActor_1() {
        return actor_1;
    }

    public void setActor_1(String actor_1) {
        this.actor_1 = actor_1;
    }

    public String getActor_2() {
        return actor_2;
    }

    public void setActor_2(String actor_2) {
        this.actor_2 = actor_2;
    }

    public String getActor_3() {
        return actor_3;
    }

    public void setActor_3(String actor_3) {
        this.actor_3 = actor_3;
    }

    public String getActor_4() {
        return actor_4;
    }

    public void setActor_4(String actor_4) {
        this.actor_4 = actor_4;
    }

    public String getEstimate() {
        return estimate;
    }

    public void setEstimate(String estimate) {
        this.estimate = estimate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
