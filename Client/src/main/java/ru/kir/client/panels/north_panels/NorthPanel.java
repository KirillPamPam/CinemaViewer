package ru.kir.client.panels.north_panels;

import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import ru.kir.client.panels.east_panels.EastPanel;

/**
 * Created by Kirill Zhitelev on 02.12.2015.
 */
public class NorthPanel extends HorizontalPanel {
    private TextBox search = new TextBox();
    private Label cinemaViewer = new Label("CinemaViewer");
    private static volatile NorthPanel northPanel;

    private NorthPanel() {
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

}
