package com.prepper.prepper.model;

import jakarta.persistence.*;

@Entity
public class Recipes {

    @Id
    @GeneratedValue
    private Long ID;

    private String imageURL;

    private String title;

    private String measurements;

    private String ingredients;

    private String description;

    private String steps;

    private Long duration;

    private Long calories;

    private Long saves;

    private boolean isPublic;

    private Long userID;

    // Getters
    public Long getID() {
        return ID;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getTitle() {
        return title;
    }

    public String getMeasurements() {
        return measurements;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getDescription() {
        return description;
    }

    public String getSteps() {
        return steps;
    }

    public Long getDuration() {
        return duration;
    }

    public Long getCalories() {
        return calories;
    }

    public Long getSaves() {
        return saves;
    }

    public boolean getIsPublic() {
        return isPublic;
    }

    public Long getUserID() {
        return userID;
    }

    // Setters
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMeasurements(String measurements) {
        this.measurements = measurements;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public void setCalories(Long calories) {
        this.calories = calories;
    }

    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

}
