package com.prepper.prepper.model;

import jakarta.persistence.*;

@Entity
public class Recipes {

    @Id
    @GeneratedValue
    private Integer recipeID;

    private String title;

    private String imageURL;

    private String measurements;

    private String ingredients;

    private String description;

    private String instructions;

    private Integer prepTime;

    private Integer calories;

    private Integer saves;

    private boolean isPublic;

    private Integer userID;

    public Recipes(String imageURL, String title, String measurements, String ingredients, String description, String instructions, Integer prepTime, Integer calories, Integer saves, boolean isPublic, Integer userID) {
        this.title = title;
        this.imageURL = imageURL;
        this.measurements = measurements;
        this.ingredients = ingredients;
        this.description = description;
        this.instructions = instructions;
        this.prepTime = prepTime;
        this.calories = calories;
        this.saves = saves;
        this.isPublic = isPublic;
        this.userID = userID;
    }
    public Recipes() {}

    // Getters
    public Integer getRecipeID() {
        return recipeID;
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

    public String getInstructions() {
        return instructions;
    }

    public Integer getPrepTime() {
        return prepTime;
    }

    public Integer getCalories() {
        return calories;
    }

    public Integer getSaves() {
        return saves;
    }

    public boolean getIsPublic() {
        return isPublic;
    }

    public Integer getUserID() {
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

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

}
