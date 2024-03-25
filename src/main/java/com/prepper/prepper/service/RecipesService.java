package com.prepper.prepper.service;

import com.prepper.prepper.model.MealPlans;
import com.prepper.prepper.model.Recipes;
import com.prepper.prepper.model.SavedRecipes;
import com.prepper.prepper.repository.RecipesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipesService {
    @Autowired
    private RecipesRepository recipesRepository;

    @Autowired
    private MealPlansService mpService;

    @Autowired
    private SavedRecipesService savedRecipesService;

    /**
     *  Retrieves all recipes given userID
     *
     * @param userId The userID
     * @return A list of recipes
     */
    public List<Recipes> getRecipesByUser(Integer userId) {

        return recipesRepository.findByUserID(userId);
    }

    /**
     *  Retrieves recipe given recipeID
     *
     * @param recipeId The recipeID
     * @return A recipe
     */
    public Recipes getRecipe(Integer recipeId) {

        return recipesRepository.findByRecipeID(recipeId);
    }

    /**
     *  Retrieves all public recipes
     *
     * @return A list of recipes
     */
    public List<Recipes> getPublicRecipes() {
        return recipesRepository.findByIsPublic(true);
    }

    /**
     *  Retrieves all recipes in database
     *
     * @return A list of recipes
     */
    public List<Recipes> getAllRecipes() {
        return recipesRepository.findAll();
    }

    /**
     *  Saves recipe into database
     *
     * @param recipe The recipe to be saved
     * @return Saved recipe
     */
    public Recipes saveRecipe(Recipes recipe) {
        return recipesRepository.save(recipe);
    }

    /**
     *  Remove recipe given the recipeID
     *
     * @param recipeId RecipeId of the recipe to be removed
     * @return Referenced recipe
     */
    public Recipes removeRecipe(Integer recipeId) {
        boolean exists = recipesRepository.existsById(recipeId);
        if (!exists) {
            throw new IllegalStateException(
                    "Recipe with id " + recipeId + " does not exists"
            );
        }
        Recipes recipe = recipesRepository.getReferenceById(recipeId);

        List<MealPlans> mealPlansToDelete = mpService.getMealPlansByRecipe(recipeId);
        List<SavedRecipes> savedRecipesToDelete = savedRecipesService.getSavedRecipesByRecipe(recipeId);

        for (MealPlans mealPlans : mealPlansToDelete) {
            mpService.deleteMealPlan(mealPlans.getMealPlanID());
        }

        for (SavedRecipes savedRecipe : savedRecipesToDelete) {
            savedRecipesService.removeSavedRecipe(savedRecipe.getUserID(), savedRecipe.getRecipeID());
        }
        recipesRepository.deleteById(recipeId);
        return recipe;
    }

    /**
     *  Updated existing recipe
     *
     * @param recipe Updated recipe from user
     * @return Updated recipe from database
     */
    public Recipes updateRecipe(Recipes recipe) {
        recipesRepository.save(recipe);
        return recipesRepository.findByRecipeID(recipe.getRecipeID());
    }
}
