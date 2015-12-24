package ru.kir.client.common;

import com.google.gwt.user.client.ui.Image;
import ru.kir.client.resources.MyResources;

/**
 * Created by Kirill Zhitelev on 02.12.2015.
 */
public class CinemaService {

    public static String[] getUrlsFromFile() {
        return MyResources.INSTANCE.getUrls().getText().split("\n");
    }

    public static String[] getHeadersFromFile() {
        return MyResources.INSTANCE.getHeaders().getText().split("\n");
    }

    public static void setSizeToImage(Image[] arrayImage, String width, String height) {
        for (Image images: arrayImage) {
            images.setSize(width, height);
        }
    }

    public static void setSizeToImage(Image image, String width, String height) {
        image.setSize(width, height);
    }

    public static String[] getNews() {
        return MyResources.INSTANCE.getNews().getText().split("\n");
    }

}
