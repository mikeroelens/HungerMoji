package com.mikeroelens.emojification.model;

import java.util.List;

abstract public class SelectItemList<T> {
    private int index = 0;
    abstract List<T> getItems();

    public T getCurrentItem() {
        return getItems().get(index);
    }

    public T next() {
        if (index == getItems().size() - 1){
            index = 0;
        }
        else {
            index++;
        }

        return getCurrentItem();
    }
}
