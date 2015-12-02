package ru.kir.client.panels;

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

    public CenterPanel() {
        addComposition();
    }

    private void addComposition() {
        grid.setWidth("700px");

        Label news = new Label("News");
        Label rating = new Label("Rating of films");
        Label article = new Label("Articles");

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
        grid.setWidget(0, 1, new InlineLabel(getHeadersFromFile()[0]));
        grid.setWidget(0, 2, images[1]);
        grid.setWidget(0, 3, new InlineLabel(getHeadersFromFile()[1]));

        grid.setWidget(1, 0, images[2]);
        grid.setWidget(1, 1, new InlineLabel(getHeadersFromFile()[2]));
        grid.setWidget(1, 2, images[3]);
        grid.setWidget(1, 3, new InlineLabel(getHeadersFromFile()[3]));

        grid.setWidget(2, 0, images[4]);
        grid.setWidget(2, 1, new InlineLabel(getHeadersFromFile()[4]));
        grid.setWidget(2, 2, images[5]);
        grid.setWidget(2, 3, new InlineLabel(getHeadersFromFile()[5]));
    }

}
