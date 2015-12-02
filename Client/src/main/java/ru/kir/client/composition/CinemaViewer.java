package ru.kir.client.composition;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;


public class CinemaViewer implements EntryPoint {
    public void onModuleLoad() {
        RootPanel.get().add(new CinemaComposition());
    }
}
