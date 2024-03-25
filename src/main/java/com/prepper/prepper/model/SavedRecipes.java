package com.prepper.prepper.model;

import jakarta.persistence.*;

/**
 * This class provides the structure of the Saved_Recipes table in the database
 *
 */
@Entity(name="SavedRecipes")
@Table
public class SavedRecipes {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer recipeID;
    private Integer userID;

    /**
     * Constructor used for configuration
     */
    public SavedRecipes(Integer recipeID, Integer userID) {
        this.recipeID = recipeID;
        this.userID = userID;
    }

    /**
     * Default constructor required by Spring
     */
    public SavedRecipes() {
    }

    /**
     * Getters and Setters
     */
    public Integer getRecipeID() {
        return recipeID;
    }

    public Integer getID() {
        return id;
    }

    public void setRecipeID(Integer recipeID) {
        this.recipeID = recipeID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }
}
