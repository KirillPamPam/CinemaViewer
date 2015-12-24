package ru.kir.client.panels.north_panels;

import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.*;
import ru.kir.client.common.ContentCallback;
import ru.kir.client.panels.ContentPanel;
import ru.kir.client.panels.east_panels.EastPanel;
import ru.kir.client.pojo.Content;
import ru.kir.client.web.ContentService;

import java.util.List;

/**
 * Created by Kirill Zhitelev on 02.12.2015.
 */
public class NorthPanel extends HorizontalPanel {
    private  TextBox search = new TextBox();
    private Label cinemaViewer = new Label("CinemaViewer");
    private static volatile NorthPanel northPanel;
    private  ContentService contentService = new ContentService();

    private NorthPanel() {
        click();
    }

    private void addComposition() {
        setStyleName("horizontalPanel");
        setSpacing(50);
        search.setVisibleLength(30);

        search.getElement().setAttribute("placeholder", "Search");
        cinemaViewer.setStyleName("labelCinema");
        setStyleName("border");

        add(cinemaViewer);
        add(search);
        setCellVerticalAlignment(search, HasVerticalAlignment.ALIGN_MIDDLE);
        setCellVerticalAlignment(cinemaViewer, HasVerticalAlignment.ALIGN_BOTTOM);
    }

    public static NorthPanel create() {
        NorthPanel localNorthPanel = northPanel;
        if(localNorthPanel == null) {
            synchronized (EastPanel.class) {
                localNorthPanel = northPanel;
                if(localNorthPanel == null) {
                    northPanel = localNorthPanel = new NorthPanel();
                }
            }
        }
        localNorthPanel.addComposition();
        return localNorthPanel;
    }

    private String getPath() {
        return "/" + search.getText();
    }

    public void click() {
        search.addKeyPressHandler(new KeyPressHandler() {
            @Override
            public void onKeyPress(KeyPressEvent event) {
                if (event.getCharCode() == KeyCodes.KEY_ENTER) {
                    contentService.getContent(getPath(), new ContentCallback() {
                        @Override
                        public void call(List<Content> contents) {
                            ContentPanel contentPanel = new ContentPanel();
                            contentPanel.createContentList(contents);
                            contentPanel.addComposition();
                            History.newItem("results");
                            RootPanel.get().clear();
                            RootPanel.get().add(contentPanel);

                            workWithHistory(contentPanel, contents);
                        }
                    });
                }
            }
        });
    }

    private void workWithHistory(final ContentPanel contentPanel, final List<Content> contents) {
        History.addValueChangeHandler(new ValueChangeHandler<String>() {
            @Override
            public void onValueChange(ValueChangeEvent<String> event) {
                String historyToken = event.getValue();
                if(historyToken.equals("results")) {
                    contentPanel.getContentVPanel().clear();
                    contentPanel.createContentList(contents);
                    contentPanel.addComposition();
                    RootPanel.get().clear();
                    RootPanel.get().add(contentPanel);
                }
/*                for (Content content: contents) {
                    if(historyToken.equals(content.getFullName())) {
                        contentPanel.createPersonPanel(content);
                    }
                    else if(historyToken.equals(content.getFilmName())) {
                        contentPanel.createFilmPanel(content);
                    }
                }*/
            }
        });
        History.fireCurrentHistoryState();
    }
}
