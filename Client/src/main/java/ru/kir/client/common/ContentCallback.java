package ru.kir.client.common;

import ru.kir.client.pojo.Content;

import java.util.List;

/**
 * Created by Kirill Zhitelev on 14.12.2015.
 */
public interface ContentCallback {
    void call(List<Content> contents);
}
