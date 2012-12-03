package com.mikemunhall.jara.model;

import org.joda.time.Duration;

public class Recipe {

    private String id;
    private String userId;
    private String recipeName;
    private String description;
    private int servings;
    private Duration totalPrepTime;
    private Duration totalCookTime;
    private Duration totalActiveTime;
    private TagToRecipe[] tags;
    private IngredientToRecipe[] ingredients;
    private Direction[] directions;

    public Recipe() { }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public Duration getTotalPrepTime() {
        return totalPrepTime;
    }

    public void setTotalPrepTime(Duration totalPrepTime) {
        this.totalPrepTime = totalPrepTime;
    }

    public Duration getTotalCookTime() {
        return totalCookTime;
    }

    public void setTotalCookTime(Duration totalCookTime) {
        this.totalCookTime = totalCookTime;
    }

    public Duration getTotalActiveTime() {
        return totalActiveTime;
    }

    public void setTotalActiveTime(Duration totalActiveTime) {
        this.totalActiveTime = totalActiveTime;
    }

    public IngredientToRecipe[] getIngredients() {
        return ingredients;
    }

    public TagToRecipe[] getTags() {
        return tags;
    }

    public void setTags(TagToRecipe[] tags) {
        this.tags = tags;
    }

    public void setIngredients(IngredientToRecipe[] ingredients) {
        this.ingredients = ingredients;
    }

    public Direction[] getDirections() {
        return directions;
    }

    public void setDirections(Direction[] directions) {
        this.directions = directions;
    }
}
