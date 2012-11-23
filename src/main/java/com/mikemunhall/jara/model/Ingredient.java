package com.mikemunhall.jara.model;

public class Ingredient {

    private long id;
    private String description;

    public Ingredient() { }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
