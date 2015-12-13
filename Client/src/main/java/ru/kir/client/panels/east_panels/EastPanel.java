package ru.kir.client.panels.east_panels;

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
public class EastPanel extends VerticalPanel {
    private Label soonInCinema1 = new Label("Soon in the cinema");
    private Image secondPoster = new Image(MyResources.INSTANCE.getThirdPoster());
    private Label actor = new Label("Actor");
    private static volatile EastPanel eastPanel;

    private EastPanel() {

    }

    private void addComposition() {
        goToSite();

        secondPoster.getElement().getStyle().setCursor(Style.Cursor.POINTER);
        soonInCinema1.setStyleName("labelWestAndEast");
        actor.setStyleName("labelWestAndEast");
        setStyleName("border");

        add(soonInCinema1);
        add(secondPoster);
        add(actor);
        setCellHorizontalAlignment(soonInCinema1, HasHorizontalAlignment.ALIGN_CENTER);
        setCellHorizontalAlignment(actor, HasHorizontalAlignment.ALIGN_CENTER);
    }

    private void goToSite() {
        final String secondSite = CinemaService.getUrlsFromFile()[1];
        secondPoster.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Window.open(secondSite, null, null);
            }
        });
    }

    public static EastPanel create() {
        EastPanel localEastPanel = eastPanel;
        if(localEastPanel == null) {
            synchronized (EastPanel.class) {
                localEastPanel = eastPanel;
                if(localEastPanel == null) {
                    eastPanel = localEastPanel = new EastPanel();
                }
            }
        }
        localEastPanel.addComposition();
        return localEastPanel;
    }

}
