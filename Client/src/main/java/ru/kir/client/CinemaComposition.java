package ru.kir.client;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import ru.kir.client.resources.MyResources;


/**
 * Created by Kirill Zhitelev on 29.11.2015.
 */
public class CinemaComposition extends Composite {
    private DockPanel dockPanel = new DockPanel();
    private TextBox search = new TextBox();
    private Image firstPoster = new Image(MyResources.INSTANCE.getFirstPoster());
    private Image secondPoster = new Image(MyResources.INSTANCE.getThirdPoster());
    private Image first_news = new Image(MyResources.INSTANCE.getFirstNew());
    private Image second_news = new Image(MyResources.INSTANCE.getSecondNew());
    private Image third_news = new Image(MyResources.INSTANCE.getThirdNew());
    private Image fourth_news = new Image(MyResources.INSTANCE.getFourthNew());
    private Image fifth_news = new Image(MyResources.INSTANCE.getFifthNew());
    private Image sixth_news = new Image(MyResources.INSTANCE.getSixthtNew());
    private String firstSite, secondSite;

    public CinemaComposition() {
        initWidget(dockPanel);

        addComposition();
        goToSite();
    }

    private void addComposition() {
        HorizontalPanel horizontalPanel = new HorizontalPanel();
        HorizontalPanel newsHorizontalPanel = new HorizontalPanel();
        HorizontalPanel newsHorizontalPanel_1 = new HorizontalPanel();
        VerticalPanel centerVerticalPanel = new VerticalPanel();
        VerticalPanel westVerticalPanel = new VerticalPanel();
        VerticalPanel eastVerticalPanel = new VerticalPanel();

        horizontalPanel.setStyleName("horizontalPanel");
        horizontalPanel.setSpacing(50);

        firstPoster.getElement().getStyle().setCursor(Style.Cursor.POINTER);
        secondPoster.getElement().getStyle().setCursor(Style.Cursor.POINTER);
        search.getElement().setAttribute("placeholder", "Search");

        dockPanel.setStyleName("dockpanel");
        dockPanel.setWidth("100%");
        dockPanel.setHeight("1000px");

        Label cinemaViewer = new Label("CinemaViewer");
        Label news = new Label("News");
        Label rating = new Label("Rating of films");
        Label article = new Label("Articles");
        Label soonInCinema = new Label("Soon in the cinema");
        Label soonInCinema1 = new Label("Soon in the cinema");
        Label filmOfDay = new Label("Film of day");
        Label actor = new Label("Actor");

        soonInCinema.setStyleName("labelWestAndEast");
        soonInCinema1.setStyleName("labelWestAndEast");
        filmOfDay.setStyleName("labelWestAndEast");
        actor.setStyleName("labelWestAndEast");
        news.setStyleName("labelCenter");
        rating.setStyleName("labelCenter");
        article.setStyleName("labelCenter");

        westVerticalPanel.add(soonInCinema);
        westVerticalPanel.add(firstPoster);
        westVerticalPanel.add(filmOfDay);
        westVerticalPanel.setCellHorizontalAlignment(soonInCinema, HasHorizontalAlignment.ALIGN_CENTER);
        westVerticalPanel.setCellHorizontalAlignment(filmOfDay, HasHorizontalAlignment.ALIGN_CENTER);

        eastVerticalPanel.add(soonInCinema1);
        eastVerticalPanel.add(secondPoster);
        eastVerticalPanel.add(actor);
        eastVerticalPanel.setCellHorizontalAlignment(soonInCinema1, HasHorizontalAlignment.ALIGN_CENTER);
        eastVerticalPanel.setCellHorizontalAlignment(actor, HasHorizontalAlignment.ALIGN_CENTER);

        setSizeToImage();

        newsHorizontalPanel.add(first_news);
        newsHorizontalPanel.add(second_news);
        newsHorizontalPanel.add(third_news);
        newsHorizontalPanel_1.add(fourth_news);
        newsHorizontalPanel_1.add(fifth_news);
        newsHorizontalPanel_1.add(sixth_news);

        centerVerticalPanel.add(news);
        centerVerticalPanel.add(newsHorizontalPanel);
        centerVerticalPanel.add(newsHorizontalPanel_1);
        centerVerticalPanel.add(article);
        centerVerticalPanel.add(rating);

        cinemaViewer.setStyleName("labelCinema");
        horizontalPanel.add(cinemaViewer);
        horizontalPanel.add(search);
        horizontalPanel.setCellVerticalAlignment(search, HasVerticalAlignment.ALIGN_MIDDLE);
        horizontalPanel.setCellVerticalAlignment(cinemaViewer, HasVerticalAlignment.ALIGN_BOTTOM);

        dockPanel.add(westVerticalPanel, DockPanel.WEST);
        dockPanel.add(eastVerticalPanel, DockPanel.EAST);
        dockPanel.add(horizontalPanel, DockPanel.NORTH);
        dockPanel.add(centerVerticalPanel, DockPanel.CENTER);


        dockPanel.setCellHorizontalAlignment(westVerticalPanel, HasHorizontalAlignment.ALIGN_CENTER);
        dockPanel.setCellHorizontalAlignment(eastVerticalPanel, HasHorizontalAlignment.ALIGN_CENTER);
        dockPanel.setCellHorizontalAlignment(horizontalPanel, HasHorizontalAlignment.ALIGN_CENTER);

        dockPanel.setCellHeight(horizontalPanel, "100px");
    }

    private void getUrlsFromFile() {
        String[] urls = MyResources.INSTANCE.getUrls().getText().split("\n");

        firstSite = urls[0];
        secondSite = urls[1];
    }

    private void goToSite() {
        getUrlsFromFile();
        firstPoster.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Window.open(firstSite, null, null);
            }
        });
        secondPoster.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Window.open(secondSite, null, null);
            }
        });
    }

    private void setSizeToImage() {
        first_news.setSize("75px", "100px");
        second_news.setSize("75px", "100px");
        third_news.setSize("75px", "100px");
        fourth_news.setSize("75px", "100px");
        fifth_news.setSize("75px", "100px");
        sixth_news.setSize("75px", "100px");
    }
}
