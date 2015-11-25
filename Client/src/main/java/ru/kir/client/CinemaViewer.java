package ru.kir.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import ru.kir.client.resources.MyResources;

public class CinemaViewer implements EntryPoint {
    public void onModuleLoad() {
        AbsolutePanel absolutePanel = new AbsolutePanel();
        TextBox search = new TextBox();
        HTML name = new HTML("<h1>CinemaViewer</h1>");

        absolutePanel.setHeight("150%");
        Image firstWest = new Image(MyResources.INSTANCE.getFirstPoster());
        Image thirdPoster = new Image(MyResources.INSTANCE.getThirdPoster());

        firstWest.setStyleName("firstPoster");
        thirdPoster.setStyleName("secondPoster");
        search.getElement().setAttribute("placeholder", "Search");

        absolutePanel.add(firstWest);
        absolutePanel.add(name, 350, 20);
        absolutePanel.add(search, 700, 80);
        absolutePanel.add(thirdPoster);

        RootPanel.get().add(absolutePanel);
    }
}
