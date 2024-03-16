package com.prepper.prepper.model;

import jakarta.persistence.*;

@Entity(name="SavedRecipes")
@Table
public class SavedRecipes {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer recipeID;
    private Integer userID;

    public SavedRecipes(Integer recipeID, Integer userID) {
        this.recipeID = recipeID;
        this.userID = userID;
    }
    public SavedRecipes() {
    }

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
