package ru.kir.client.panels.center_panels;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.*;
import ru.kir.client.resources.MyResources;

import static ru.kir.client.common.CinemaService.getHeadersFromFile;
import static ru.kir.client.common.CinemaService.setSizeToImage;

/**
 * Created by Kirill Zhitelev on 02.12.2015.
 */
public class CenterPanel extends VerticalPanel {
    private Grid grid = new Grid(3, 4);
    private Image[] images = {new Image(MyResources.INSTANCE.getFirstNew()),
            new Image(MyResources.INSTANCE.getSecondNew()),
            new Image(MyResources.INSTANCE.getThirdNew()),
            new Image(MyResources.INSTANCE.getFourthNew()),
            new Image(MyResources.INSTANCE.getFifthNew()),
            new Image(MyResources.INSTANCE.getSixthtNew())};
    private Anchor firstAnchor = new Anchor(getHeadersFromFile()[0]);
    private Anchor secondAnchor = new Anchor(getHeadersFromFile()[1]);
    private Anchor thirdAnchor = new Anchor(getHeadersFromFile()[2]);
    private Anchor fourthAnchor = new Anchor(getHeadersFromFile()[3]);
    private Anchor fifthAnchor = new Anchor(getHeadersFromFile()[4]);
    private Anchor sixthAnchor = new Anchor(getHeadersFromFile()[5]);
    public static int CURRENT_NEWS;

    public CenterPanel() {
        addComposition();

        goToNews();
    }

    private void addComposition() {
        grid.setWidth("700px");

        Label news = new Label("News");
        Label rating = new Label("Rating of films");
        Label article = new Label("Articles");

        grid.setStyleName("border");
        news.setStyleName("labelCenter");
        rating.setStyleName("labelCenter");
        article.setStyleName("labelCenter");

        setSizeToImage(images, "75px", "100px");
        setRowsAndColumns();

        add(news);
        add(grid);
        add(article);
        add(rating);
    }

    private void setRowsAndColumns() {
        grid.setWidget(0, 0, images[0]);
        grid.setWidget(0, 1, firstAnchor);
        grid.setWidget(0, 2, images[1]);
        grid.setWidget(0, 3, secondAnchor);

        grid.setWidget(1, 0, images[2]);
        grid.setWidget(1, 1, thirdAnchor);
        grid.setWidget(1, 2, images[3]);
        grid.setWidget(1, 3, fourthAnchor);

        grid.setWidget(2, 0, images[4]);
        grid.setWidget(2, 1, fifthAnchor);
        grid.setWidget(2, 2, images[5]);
        grid.setWidget(2, 3, sixthAnchor);
    }

    private void goToNews() {
        firstAnchor.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                CURRENT_NEWS = 1;
                History.newItem("news/1");
                RootPanel.get().clear();
                RootPanel.get().add(new NewsPanel());
            }
        });
        secondAnchor.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                CURRENT_NEWS = 2;
                History.newItem("news/2");
                RootPanel.get().clear();
                RootPanel.get().add(new NewsPanel());
            }
        });
        thirdAnchor.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                CURRENT_NEWS = 3;
                History.newItem("news/3");
                RootPanel.get().clear();
                RootPanel.get().add(new NewsPanel());
            }
        });
        fourthAnchor.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                CURRENT_NEWS = 4;
                History.newItem("news/4");
                RootPanel.get().clear();
                RootPanel.get().add(new NewsPanel());
            }
        });
        fifthAnchor.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                CURRENT_NEWS = 5;
                History.newItem("news/5");
                RootPanel.get().clear();
                RootPanel.get().add(new NewsPanel());
            }
        });
        sixthAnchor.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                CURRENT_NEWS = 6;
                History.newItem("news/6");
                RootPanel.get().clear();
                RootPanel.get().add(new NewsPanel());
            }
        });

    }

}
