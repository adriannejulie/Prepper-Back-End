package com.prepper.prepper.controller;

import com.prepper.prepper.model.Recipes;
import com.prepper.prepper.model.SavedRecipes;
import com.prepper.prepper.model.Users;
import com.prepper.prepper.repository.SavedRecipesRepository;
import com.prepper.prepper.service.SavedRecipesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class SavedRecipesController {

    @Autowired
    private SavedRecipesService savedRecipeService;

    @Autowired
    private SavedRecipesRepository savedRecipesRepository;

    /**
     * Retrieves all saved recipes corresponding to a userID
     * 
     * @param userID
     * @return List of Recipes objects, Response Entity codes and headers
     */
    @GetMapping("/getSavedRecipes/{userID}")
    public ResponseEntity<List<Recipes>> getSavedRecipe(@PathVariable Integer userID) {
        List<Recipes> recipes = savedRecipeService.getSavedRecipes(userID);
        if (recipes != null) {
            return ResponseEntity
                    .ok()
                    .body(recipes);
        }
        else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("No saved recipes exist", "userID: " + userID);
            return ResponseEntity
                    .badRequest()
                    .headers(headers)
                    .build();
        }
    }

    /**
     * Add a recipe to SavedRecipeRepository
     * 
     * @param saveRecipe
     * @return SavedRecipe object, Response Entity codes and headers
     */
    @PostMapping("/addSavedRecipe")
    public ResponseEntity<SavedRecipes> addSavedRecipe(@RequestBody SavedRecipes saveRecipe  ) {
        List<SavedRecipes> savedRecipes = savedRecipesRepository.findByUserID(saveRecipe.getUserID());
        boolean exists = false;

        for (SavedRecipes recipe : savedRecipes) {
            if (recipe.getRecipeID().equals(saveRecipe.getRecipeID())) {
                 exists = true;
                 break;
            }
        }
        if (exists) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Recipe already saved.", "RecipeID: " + saveRecipe.getRecipeID());
            return ResponseEntity
                    .badRequest()
                    .headers(headers)
                    .build();
        } else {
            SavedRecipes newSavedRecipe = savedRecipeService.saveRecipe(saveRecipe);
            return ResponseEntity
                    .ok()
                    .body(newSavedRecipe);
        }
    }

    /**
     * Deletes a Users Object and all recipes with corresponding recipeID
     * 
     * @param userId
     * @param recipeId
     * @return Response Entity codes and headers
     */
    @DeleteMapping(path = "/removeSavedRecipe/{userID}-{recipeID}")
    public ResponseEntity<Object> removeRecipe(
            @PathVariable("userID") Integer userId,
            @PathVariable("recipeID")Integer recipeId
            ) {
        boolean removed = savedRecipeService.removeSavedRecipe(userId, recipeId);
        if (removed) {
            return ResponseEntity
                    .ok().build();
        }
        else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Error in removing saved recipe.", "RecipeID: " + recipeId);
            return ResponseEntity
                    .badRequest()
                    .headers(headers)
                    .build();
        }
    }
}
