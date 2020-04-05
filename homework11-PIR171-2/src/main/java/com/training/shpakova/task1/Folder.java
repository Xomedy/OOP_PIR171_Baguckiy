package com.training.shpakova.task1;

public interface Folder {
    String getName();

    Folder getInstance();

    int getSize();

    void add(Folder folder);

    void print(int count);

    void setPosition(int position);
}
