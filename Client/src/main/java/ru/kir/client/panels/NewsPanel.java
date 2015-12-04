package ru.kir.client.panels;

import com.google.gwt.user.client.ui.*;
import ru.kir.client.resources.MyResources;

import static ru.kir.client.common.CinemaService.*;
import static ru.kir.client.panels.CenterPanel.CURRENT_NEWS;

/**
 * Created by Kirill Zhitelev on 03.12.2015.
 */
public class NewsPanel extends Composite {
    private DockPanel dockPanel = new DockPanel();
    private NorthPanel northPanel = NorthPanel.create();
    private WestPanel westPanel = WestPanel.create();
    private EastPanel eastPanel = EastPanel.create();
    private Image[] images = {new Image(MyResources.INSTANCE.getFirstNew()),
            new Image(MyResources.INSTANCE.getSecondNew()),
            new Image(MyResources.INSTANCE.getThirdNew()),
            new Image(MyResources.INSTANCE.getFourthNew()),
            new Image(MyResources.INSTANCE.getFifthNew()),
            new Image(MyResources.INSTANCE.getSixthtNew())};
    private VerticalPanel newsVerticalPanel = new VerticalPanel();
    private FlowPanel flowPanel = new FlowPanel();
    private Label news = new Label();
    private Label header = new Label();

    public NewsPanel() {
        initWidget(dockPanel);
        addComposition();

        addNews();
    }

    private void addComposition() {
        setSizeToImage(images, "182px", "252px");

        for (Image image: images) {
            image.setStyleName("imageFloat");
        }

        flowPanel.setStyleName("border");
        dockPanel.setStyleName("dockpanel");
        header.setStyleName("labelCenter");
        news.setStyleName("styleNews");
        dockPanel.setWidth("100%");
        dockPanel.setHeight("1000px");

        createVerticalPanel();

        dockPanel.add(westPanel, DockPanel.WEST);
        dockPanel.add(eastPanel, DockPanel.EAST);
        dockPanel.add(northPanel, DockPanel.NORTH);
        dockPanel.add(newsVerticalPanel, DockPanel.CENTER);

        dockPanel.setCellHorizontalAlignment(westPanel, HasHorizontalAlignment.ALIGN_CENTER);
        dockPanel.setCellHorizontalAlignment(eastPanel, HasHorizontalAlignment.ALIGN_CENTER);
        dockPanel.setCellHorizontalAlignment(northPanel, HasHorizontalAlignment.ALIGN_CENTER);
        dockPanel.setCellVerticalAlignment(newsVerticalPanel, HasVerticalAlignment.ALIGN_TOP);

        dockPanel.setCellHeight(northPanel, "100px");
    }

    private void createVerticalPanel() {
        Label news = new Label("News");
        news.setStyleName("labelCenter");

        newsVerticalPanel.add(news);
    }

    private void addNews() {
        if(CURRENT_NEWS == 1) {
            flowPanel.clear();
            header.setText(getHeadersFromFile()[0]);
            news.setText(getNews()[0]);
            flowPanel.add(header);
            flowPanel.add(images[0]);
            flowPanel.add(news);
            newsVerticalPanel.add(flowPanel);
        }
        if(CURRENT_NEWS == 2) {
            flowPanel.clear();
            header.setText(getHeadersFromFile()[1]);
            news.setText(getNews()[1]);
            flowPanel.add(header);
            flowPanel.add(images[1]);
            flowPanel.add(news);
            newsVerticalPanel.add(flowPanel);
        }
        if(CURRENT_NEWS == 3) {
            flowPanel.clear();
            header.setText(getHeadersFromFile()[2]);
            news.setText(getNews()[2]);
            flowPanel.add(header);
            flowPanel.add(images[2]);
            flowPanel.add(news);
            newsVerticalPanel.add(flowPanel);
        }
        if(CURRENT_NEWS == 4) {
            flowPanel.clear();
            header.setText(getHeadersFromFile()[3]);
            news.setText(getNews()[3]);
            flowPanel.add(header);
            flowPanel.add(images[3]);
            flowPanel.add(news);
            newsVerticalPanel.add(flowPanel);
        }
        if(CURRENT_NEWS == 5) {
            flowPanel.clear();
            header.setText(getHeadersFromFile()[4]);
            news.setText(getNews()[4]);
            flowPanel.add(header);
            flowPanel.add(images[4]);
            flowPanel.add(news);
            newsVerticalPanel.add(flowPanel);
        }
        if(CURRENT_NEWS == 6) {
            flowPanel.clear();
            header.setText(getHeadersFromFile()[5]);
            news.setText(getNews()[5]);
            flowPanel.add(header);
            flowPanel.add(images[5]);
            flowPanel.add(news);
            newsVerticalPanel.add(flowPanel);
        }
    }
}
