package com.prepper.prepper.service;

import com.prepper.prepper.model.Recipes;
import com.prepper.prepper.model.SavedRecipes;
import com.prepper.prepper.repository.SavedRecipesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SavedRecipesService {
    @Autowired
    private SavedRecipesRepository savedRecipesRepository;
    @Autowired
    private RecipesService recipesService;

    public List<Recipes> getSavedRecipes(Integer userID) {
        List<SavedRecipes> savedRecipes = savedRecipesRepository.findByUserID(userID);
        List<Recipes> recipes = new ArrayList<Recipes>();
        for (SavedRecipes savedRecipe : savedRecipes) {
            Integer recipeId = savedRecipe.getRecipeID();
            recipes.add(recipesService.getRecipe(recipeId));
        }
        return recipes;
    }

    public SavedRecipes saveRecipe(SavedRecipes savedRecipe) {
        Integer recipeID = savedRecipe.getRecipeID();
        System.out.println(recipeID);
        Recipes recipe = recipesService.getRecipe(recipeID);
        System.out.println(recipe);
        recipe.setSaves(1);
        recipesService.updateRecipe(recipe);
        return savedRecipesRepository.save(savedRecipe);
    }

    public boolean removeSavedRecipe(Integer userId, Integer recipeId) {
        List<SavedRecipes> savedRecipes = savedRecipesRepository.findByUserID(userId);
        for (SavedRecipes recipe : savedRecipes) {
            if (recipe.getRecipeID().equals(recipeId)) {
                Integer id = recipe.getID();
                savedRecipesRepository.deleteById(id);
                Recipes update = recipesService.getRecipe(recipeId);
                update.setSaves(-1);
                recipesService.updateRecipe(update);
                return true;
            }
        }
        return false;

    }

    public List<SavedRecipes> getSavedRecipesByUser(Integer userID){
        return savedRecipesRepository.findByUserID(userID);
    }

    public List<SavedRecipes> getSavedRecipesByRecipe(Integer recipeID){
        return savedRecipesRepository.findByRecipeID(recipeID);
    }

}
