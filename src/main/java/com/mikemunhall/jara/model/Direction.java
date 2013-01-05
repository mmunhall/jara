package com.mikemunhall.jara.model;

public class Direction {

    private String description = "";
    private int index = 0;

    public Direction() {}

    public Direction(String description, int index) {
        this.description = description;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
