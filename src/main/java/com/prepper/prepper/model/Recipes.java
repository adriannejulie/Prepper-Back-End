package com.prepper.prepper.model;

import jakarta.persistence.*;

@Entity
public class Recipes {

    @Id
    @GeneratedValue
    private Integer recipeID;

    private String title;

    private String image;

    private String measurements;

    private String ingredients;

    private String description;

    private String instructions;

    private String prepTime;

    private String calories;

    private Integer saves=0;

    private boolean isPublic;

    private Integer userID;

    public Recipes(String image, String title, String measurements, String ingredients, String description, String instructions, String prepTime, String calories, Integer saves, boolean isPublic, Integer userID) {
        this.title = title;
        this.image = image;
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

    public String getImage() {
        return image;
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

    public String getPrepTime() {
        return prepTime;
    }

    public String getCalories() {
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
    public void setImage(String image) {
        this.image = image;
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

    public void setPrepTime(String prepTime) {
        this.prepTime = prepTime;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public void setSaves(Integer n) {
        saves+=n;
    }

    @Override
    public String toString() {
        return "Recipes{" +
                "recipeID=" + recipeID +
                ", title='" + title + '\'' +
                ", imageURL='" + image + '\'' +
                ", measurements='" + measurements + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", description='" + description + '\'' +
                ", instructions='" + instructions + '\'' +
                ", prepTime=" + prepTime +
                ", calories=" + calories +
                ", saves=" + saves +
                ", isPublic=" + isPublic +
                ", userID=" + userID +
                '}';
    }
}
