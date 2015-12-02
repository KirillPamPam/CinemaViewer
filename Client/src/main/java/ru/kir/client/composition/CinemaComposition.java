package ru.kir.client.composition;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import ru.kir.client.panels.CenterPanel;
import ru.kir.client.panels.EastPanel;
import ru.kir.client.panels.NorthPanel;
import ru.kir.client.panels.WestPanel;


/**
 * Created by Kirill Zhitelev on 29.11.2015.
 */
public class CinemaComposition extends Composite {
    private DockPanel dockPanel = new DockPanel();
    private WestPanel westPanel = new WestPanel();
    private EastPanel eastPanel = new EastPanel();
    private NorthPanel northPanel = new NorthPanel();
    private CenterPanel centerPanel = new CenterPanel();

    public CinemaComposition() {
        initWidget(dockPanel);

        addComposition();
    }

    private void addComposition() {
        dockPanel.setStyleName("dockpanel");
        dockPanel.setWidth("100%");
        dockPanel.setHeight("1000px");

        dockPanel.add(westPanel, DockPanel.WEST);
        dockPanel.add(eastPanel, DockPanel.EAST);
        dockPanel.add(northPanel, DockPanel.NORTH);
        dockPanel.add(centerPanel, DockPanel.CENTER);


        dockPanel.setCellHorizontalAlignment(westPanel, HasHorizontalAlignment.ALIGN_CENTER);
        dockPanel.setCellHorizontalAlignment(eastPanel, HasHorizontalAlignment.ALIGN_CENTER);
        dockPanel.setCellHorizontalAlignment(northPanel, HasHorizontalAlignment.ALIGN_CENTER);

        dockPanel.setCellHeight(northPanel, "100px");
    }
}
