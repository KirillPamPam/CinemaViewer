package ru.kir.client.panels;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.*;
import ru.kir.client.panels.east_panels.EastPanel;
import ru.kir.client.panels.north_panels.NorthPanel;
import ru.kir.client.panels.west_panels.WestPanel;
import ru.kir.client.pojo.Content;

import java.util.List;

/**
 * Created by Kirill Zhitelev on 15.12.2015.
 */
public class ContentPanel extends Composite {
    private DockPanel dockPanel = new DockPanel();
    private NorthPanel northPanel = NorthPanel.create();
    private WestPanel westPanel = WestPanel.create();
    private EastPanel eastPanel = EastPanel.create();
    private VerticalPanel contentVPanel = new VerticalPanel();
    private FlowPanel flowPanel = new FlowPanel();
    private Label birthday = new Label();
    private Label position = new Label();
    private Label bio = new Label();
    private Label fullName = new Label();
    private Label filmName = new Label();
    private Label director = new Label();
    private Label country = new Label();
    private Label budget = new Label();
    private Label genre = new Label();
    private Label actors = new Label();
    private Label estimate = new Label();
    private Label description = new Label();

    public ContentPanel() {
        initWidget(dockPanel);
    }

    public void addComposition() {
        dockPanel.setStyleName("dockpanel");
        flowPanel.setStyleName("border");
        dockPanel.setWidth("100%");
        dockPanel.setHeight("1000px");
        birthday.setStyleName("labelContent");
        fullName.setStyleName("labelContent");
        position.setStyleName("labelContent");
        filmName.setStyleName("labelContent");
        director.setStyleName("labelContent");
        country.setStyleName("labelContent");
        budget.setStyleName("labelContent");
        genre.setStyleName("labelContent");
        actors.setStyleName("labelContent");
        estimate.setStyleName("labelContent");
        description.setStyleName("labelContent");

        dockPanel.add(westPanel, DockPanel.WEST);
        dockPanel.add(eastPanel, DockPanel.EAST);
        dockPanel.add(northPanel, DockPanel.NORTH);
        dockPanel.add(contentVPanel, DockPanel.CENTER);

        dockPanel.setCellHorizontalAlignment(westPanel, HasHorizontalAlignment.ALIGN_CENTER);
        dockPanel.setCellHorizontalAlignment(eastPanel, HasHorizontalAlignment.ALIGN_CENTER);
        dockPanel.setCellHorizontalAlignment(northPanel, HasHorizontalAlignment.ALIGN_CENTER);
        dockPanel.setCellVerticalAlignment(contentVPanel, HasVerticalAlignment.ALIGN_TOP);

        dockPanel.setCellHeight(northPanel, "100px");
    }

    public void createContentList(List<Content> contentList) {
        Label results = new Label("Results:");
        results.setStyleName("labelCenter");
        contentVPanel.add(results);
        for (final Content content: contentList) {
            if(content.getFullName() != null) {
                Anchor person = new Anchor(content.getFullName());
                contentVPanel.add(person);
                person.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
                        createPersonPanel(content);
                    }
                });
            }
            else if(content.getFilmName() != null) {
                Anchor film = new Anchor(content.getFilmName());
                contentVPanel.add(film);
                film.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
                        createFilmPanel(content);
                    }
                });
            }
        }
    }

    public void createPersonPanel(Content person) {
        contentVPanel.clear();
        flowPanel.clear();
        fullName.setText(person.getFullName());
        birthday.setText("Birthday: " + person.getBirthday());
        position.setText("Position: " + person.getPosition());
        bio.setText("Biography: " + "\n" + person.getBiography());
        flowPanel.add(fullName);
        flowPanel.add(birthday);
        flowPanel.add(position);
        flowPanel.add(bio);
        contentVPanel.add(flowPanel);

        History.newItem(person.getFullName(), true);
    }

    public void createFilmPanel(Content film) {
        contentVPanel.clear();
        flowPanel.clear();
        filmName.setText(film.getFilmName());
        director.setText("Director: " + film.getDirector());
        budget.setText("Budget: " + film.getBudget());
        genre.setText("Genre:" + film.getGenre());
        description.setText("Description: " + film.getDescription());
        estimate.setText("Estimate: " + film.getEstimate());
        country.setText("Country: " + film.getCountry());
        actors.setText("Actors:" + film.getActor_1() + ", " + film.getActor_2() + ", " + film.getActor_3() + ", "
                + film.getActor_4());
        flowPanel.add(filmName);
        flowPanel.add(director);
        flowPanel.add(country);
        flowPanel.add(genre);
        flowPanel.add(budget);
        flowPanel.add(estimate);
        flowPanel.add(actors);
        flowPanel.add(description);
        contentVPanel.add(flowPanel);

        History.newItem(film.getFilmName(), true);
    }
/*
    private void workWithHistory(final ContentPanel contentPanel, final Content content) {
        History.addValueChangeHandler(new ValueChangeHandler<String>() {
            @Override
            public void onValueChange(ValueChangeEvent<String> event) {
                String historyToken = event.getValue();
                if(historyToken.equals(content.getFullName())) {
                    contentPanel.createPersonPanel(content);
                }
                else if(historyToken.equals(content.getFilmName())) {
                    contentPanel.createFilmPanel(content);
                }
            }
        });
        History.fireCurrentHistoryState();
    }*/

    public VerticalPanel getContentVPanel() {
        return contentVPanel;
    }
}
