package com.mikemunhall.jara.model;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Recipe {

    private String id;
    private String userId;
    private String recipeName;
    private String description;
    private int servings;
    private Duration totalPrepTime;
    private Duration totalCookTime;
    private Duration totalActiveTime;
    private List<Tag> tags;
    private List<Ingredient> ingredients;
    private List<Direction> directions;

    public Recipe(String userId) {
        this.setUserId(userId);
        this.setRecipeName("New Recipe Created " + new DateTime());
        this.description = "";
        this.servings = 4;
        this.totalPrepTime = new Duration(0);
        this.totalCookTime = new Duration(0);
        this.totalActiveTime = new Duration(0);
        this.tags = new ArrayList<Tag>();
        this.ingredients = new ArrayList<Ingredient>();
        this.directions = new ArrayList<Direction>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Direction> getDirections() {
        return directions;
    }

    public void setDirections(List<Direction> directions) {
        this.directions = directions;
    }
}
