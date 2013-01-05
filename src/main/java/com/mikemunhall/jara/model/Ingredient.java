package com.mikemunhall.jara.model;

public class Ingredient {

    private float quantity = 1;
    private String unit = "";
    private String description = "";
    private int index = 0;

    public Ingredient() { }

    public Ingredient(float quantity, String unit, String description, int index) {
        this.quantity = quantity;
        this.unit = unit;
        this.description = description;
        this.index = index;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
