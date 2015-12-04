package ru.kir.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.TextResource;

/**
 * Created by Kirill Zhitelev on 25.11.2015.
 */
public interface MyResources extends ClientBundle {

    MyResources INSTANCE = GWT.create(MyResources.class);

    @Source("first.jpg")
    ImageResource getFirstPoster();

    @Source("second.jpg")
    ImageResource getThirdPoster();

    @Source("urls.txt")
    TextResource getUrls();

    @Source("news_headers.txt")
    TextResource getHeaders();

    @Source("news.txt")
    TextResource getNews();

    @Source("first_news.jpg")
    ImageResource getFirstNew();

    @Source("second_news.jpg")
    ImageResource getSecondNew();

    @Source("third_news.jpg")
    ImageResource getThirdNew();

    @Source("fourth_news.jpg")
    ImageResource getFourthNew();

    @Source("fifth_news.jpg")
    ImageResource getFifthNew();

    @Source("sixth_news.jpg")
    ImageResource getSixthtNew();
}
