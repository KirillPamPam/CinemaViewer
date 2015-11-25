package ru.kir.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

/**
 * Created by Kirill Zhitelev on 25.11.2015.
 */
public interface MyResources extends ClientBundle {

    MyResources INSTANCE = GWT.create(MyResources.class);

    @Source("first.jpg")
    ImageResource getFirstPoster();

    @Source("second.jpg")
    ImageResource getThirdPoster();
}
