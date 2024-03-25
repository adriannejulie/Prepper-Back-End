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

    /**
     *  Retrieve a list of liked recipes given userID
     *
     * @param userID the userID
     * @return A list of saved recipes if found, else return an empty list
     */
    public List<Recipes> getSavedRecipes(Integer userID) {
        List<SavedRecipes> savedRecipes = savedRecipesRepository.findByUserID(userID);
        if (savedRecipes != null){
            List<Recipes> recipes = new ArrayList<Recipes>();
            for (SavedRecipes savedRecipe : savedRecipes) {
                Integer recipeId = savedRecipe.getRecipeID();
                recipes.add(recipesService.getRecipe(recipeId));
            }
            return recipes;
        }
        return new ArrayList<>();
    }

    /**
     *  Saves a public recipe to like list
     *
     * @param savedRecipe recipe to be saved in like list
     * @return Recipe saved from the database
     */
    public SavedRecipes saveRecipe(SavedRecipes savedRecipe) {
        Integer recipeID = savedRecipe.getRecipeID();
        System.out.println(recipeID);
        Recipes recipe = recipesService.getRecipe(recipeID);
        System.out.println(recipe);
        recipe.setSaves(1);
        recipesService.updateRecipe(recipe);
        return savedRecipesRepository.save(savedRecipe);
    }

    /**
     *  Remove liked recipe given userID and recipeID
     *
     * @param userId, recipeId
     * @return True if recipe removed from like list, else return false
     */
    public boolean removeSavedRecipe(Integer userId, Integer recipeId) {
        List<SavedRecipes> savedRecipes = savedRecipesRepository.findByUserID(userId);
        if (savedRecipes != null) {
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
        }
        return false;
    }

    /**
     *  Retrieve a list of saved recipes given userID (helper function)
     *
     * @param userID the userID
     * @return A list of saved recipes
     */
    public List<SavedRecipes> getSavedRecipesByUser(Integer userID){
        return savedRecipesRepository.findByUserID(userID);
    }

    /**
     *  Retrieve a list of saved recipes given recipeID (helper function)
     *
     * @param recipeID the recipeID
     * @return A list of saved recipes
     */
    public List<SavedRecipes> getSavedRecipesByRecipe(Integer recipeID){
        return savedRecipesRepository.findByRecipeID(recipeID);
    }

}
