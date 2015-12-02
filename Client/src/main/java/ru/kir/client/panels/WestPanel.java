package ru.kir.client.panels;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import ru.kir.client.common.CinemaService;
import ru.kir.client.resources.MyResources;

/**
 * Created by Kirill Zhitelev on 02.12.2015.
 */
public class WestPanel extends VerticalPanel {
    private Image firstPoster = new Image(MyResources.INSTANCE.getFirstPoster());
    private Label soonInCinema = new Label("Soon in the cinema");
    private Label filmOfDay = new Label("Film of day");

    public WestPanel() {
        addComposition();
        goToSite();
    }

    private void addComposition() {
        firstPoster.getElement().getStyle().setCursor(Style.Cursor.POINTER);
        soonInCinema.setStyleName("labelWestAndEast");
        filmOfDay.setStyleName("labelWestAndEast");

        add(soonInCinema);
        add(firstPoster);
        add(filmOfDay);
        setCellHorizontalAlignment(soonInCinema, HasHorizontalAlignment.ALIGN_CENTER);
        setCellHorizontalAlignment(filmOfDay, HasHorizontalAlignment.ALIGN_CENTER);
    }

    private void goToSite() {
        final String firstSite = CinemaService.getUrlsFromFile()[0];
        firstPoster.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Window.open(firstSite, null, null);
            }
        });
    }


}
