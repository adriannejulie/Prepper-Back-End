package com.prepper.prepper.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class MealPlans {
    // class variables
    @Id
    @GeneratedValue
    private Integer mealPlanID;

    private LocalDate date;

    private Integer userID;

    private Integer recipeID;

    private String type;

    // constructor for MealPlans, will be used in config
    public MealPlans(Integer mealPlanID, LocalDate date, Integer userID, Integer recipeID, String type) {
        this.mealPlanID = mealPlanID;
        this.date = date;
        this.userID = userID;
        this.recipeID = recipeID;
        switch (type) {
            case "breakfast", "dinner", "lunch" -> this.type = type;
            default -> this.type = null;
        }
    }

    // default constructor
    public MealPlans() {
    }

    // getters and setters
    public Integer getMealPlanID() {
        return mealPlanID;
    }

    public void setMealPlanID(Integer mealPlanID) {
        this.mealPlanID = mealPlanID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(Integer recipeID) {
        this.recipeID = recipeID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
