package com.prepper.prepper.controller;

import com.prepper.prepper.model.MealPlans;
import com.prepper.prepper.model.Recipes;
import com.prepper.prepper.model.SavedRecipes;
import com.prepper.prepper.repository.RecipesRepository;
import com.prepper.prepper.service.MealPlansService;
import com.prepper.prepper.service.RecipesService;
import com.prepper.prepper.service.SavedRecipesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class RecipesController {

    @Autowired
    private RecipesService recipeService;

    @Autowired
    private RecipesRepository recipesRepository;

    /**
     * Retrieves all recipes of a given user
     * 
     * @param userID
     * @return List of Recipe objects and Response Entity code 200
     */
    @GetMapping("/getRecipes/{userID}")
    public ResponseEntity<List<Recipes>> getRecipesByUser(@PathVariable Integer userID) {
        List<Recipes> recipes = recipeService.getRecipesByUser(userID);
        return ResponseEntity
                .ok()
                .body(recipes);
    }

    /**
     * Retrieves all public recipes
     * 
     * @return List of Recipe objects and Response Entity code 200
     */
    @GetMapping("/getPublicRecipes")
    public ResponseEntity<List<Recipes>> getPublicRecipes() {
        List<Recipes> recipes = recipeService.getPublicRecipes();
        return ResponseEntity
                .ok()
                .body(recipes);
    }

    /**
     * Retrieves all recipes of a given recipeID
     * 
     * @param recipeID
     * @return List of Recipe objects and Response Entity code 200
     */
    @GetMapping("/getRecipe/{recipeID}")
    public ResponseEntity<Recipes> getRecipe(@PathVariable Integer recipeID) {
        Recipes recipe = recipeService.getRecipe(recipeID);
        return ResponseEntity
                .ok()
                .body(recipe);
    }

    /**
     * Retrieves all recipes
     * 
     * @return List of Recipe objects and Response Entity code 200
     */
    @GetMapping("/getAllRecipes")
    public ResponseEntity<List<Recipes>> getAllRecipes() {
        List<Recipes> recipes = recipeService.getAllRecipes();
        return ResponseEntity
                .ok()
                .body(recipes);
    }
    /**
     * Adds a recipe to the database
     * 
     * @param recipe
     * @return Recipe object to be saved and Response Entity code 200
     */
    @PostMapping("/addRecipe")
    public ResponseEntity<Recipes> addRecipe(@RequestBody Recipes recipe) {
        Recipes newRecipe = recipeService.saveRecipe(recipe);
        return ResponseEntity
                .ok()
                .body(newRecipe);
    }
    /**
     * Deletes the recipe with a given recipeID
     * 
     * @param recipeID
     * @return Recipe objects and Response Entity code 200
     */
    @DeleteMapping(path = "/deleteRecipe/{recipeID}")
    public ResponseEntity<Recipes> removeRecipe(@PathVariable("recipeID")Integer recipeId) {
        Recipes recipeToDelete = recipeService.removeRecipe(recipeId);

        return ResponseEntity
                .ok()
                .body(recipeToDelete);
    }
    /**
     * Updates recipe parameters that matches a recipeID
     * 
     * @param recipe
     * @param recipeID
     * @return Updated Recipe object and Response Entity code 200
     */
    @PutMapping("/updateRecipe/{recipeID}")
    public ResponseEntity<Recipes> updateRecipe(@RequestBody Recipes recipe, @PathVariable("recipeID") Integer recipeID) {
        Recipes update = recipesRepository.findByRecipeID(recipeID);
        update.setTitle(recipe.getTitle());
        update.setImage(recipe.getImage());
        update.setMeasurements(recipe.getMeasurements());
        update.setIngredients(recipe.getIngredients());
        update.setInstructions(recipe.getInstructions());
        update.setPrepTime(recipe.getPrepTime());
        recipesRepository.save(update);
        Recipes updatedRecipe = recipesRepository.findByRecipeID(recipeID);
        return ResponseEntity
                .ok()
                .body(updatedRecipe);
    }
}
