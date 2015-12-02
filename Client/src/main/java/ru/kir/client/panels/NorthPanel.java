package ru.kir.client.panels;

import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Created by Kirill Zhitelev on 02.12.2015.
 */
public class NorthPanel extends HorizontalPanel {
    private TextBox search = new TextBox();
    private Label cinemaViewer = new Label("CinemaViewer");

    public NorthPanel() {
        addComposition();
    }

    private void addComposition() {
        setStyleName("horizontalPanel");
        setSpacing(50);

        search.getElement().setAttribute("placeholder", "Search");
        cinemaViewer.setStyleName("labelCinema");

        add(cinemaViewer);
        add(search);
        setCellVerticalAlignment(search, HasVerticalAlignment.ALIGN_MIDDLE);
        setCellVerticalAlignment(cinemaViewer, HasVerticalAlignment.ALIGN_BOTTOM);
    }

}
