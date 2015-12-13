package ru.kir.client.main;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootPanel;
import ru.kir.client.panels.center_panels.NewsPanel;


public class CinemaViewer implements EntryPoint {
    public void onModuleLoad() {
        History.newItem("main");
        RootPanel.get().add(new CinemaComposition());

        workWithHistory();
    }

    private void workWithHistory() {
        History.addValueChangeHandler(new ValueChangeHandler<String>() {
            public void onValueChange(ValueChangeEvent<String> event) {
                String historyToken = event.getValue();
                try {
                    if (historyToken.length() == 0) {
                        History.newItem("main");
                    } else if (historyToken.matches("news/[1234]")) {
                        RootPanel.get().clear();
                        RootPanel.get().add(new NewsPanel());
                    } else if (historyToken.equals("main")) {
                        RootPanel.get().clear();
                        RootPanel.get().add(new CinemaComposition());
                    } else {
                        throw new IndexOutOfBoundsException("no! " + historyToken);
                    }
                } catch (IndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }
        });

        History.fireCurrentHistoryState();
    }
}
