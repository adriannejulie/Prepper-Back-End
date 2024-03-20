package com.prepper.prepper.controller;

import com.prepper.prepper.model.Recipes;
import com.prepper.prepper.service.RecipesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class RecipesController {

    @Autowired
    private RecipesService recipeService;

    @GetMapping("/getRecipes/{userID}")
    public ResponseEntity<List<Recipes>> getRecipesByUser(@PathVariable Integer userID) {
        List<Recipes> recipes = recipeService.getRecipesByUser(userID);
        return ResponseEntity
                .ok()
                .body(recipes);
    }

    @GetMapping("/getPublicRecipes")
    public ResponseEntity<List<Recipes>> getPublicRecipes() {
        List<Recipes> recipes = recipeService.getPublicRecipes();
        return ResponseEntity
                .ok()
                .body(recipes);
    }

    @GetMapping("/getRecipe/{recipeID}")
    public ResponseEntity<Recipes> getRecipe(@PathVariable Integer recipeID) {
        Recipes recipe = recipeService.getRecipe(recipeID);
        return ResponseEntity
                .ok()
                .body(recipe);
    }

    @GetMapping("/getAllRecipes")
    public ResponseEntity<List<Recipes>> getAllRecipes() {
        List<Recipes> recipes = recipeService.getAllRecipes();
        return ResponseEntity
                .ok()
                .body(recipes);
    }

    @PostMapping("/addRecipe")
    public ResponseEntity<Recipes> addRecipe(@RequestBody Recipes recipe) {
        Recipes newRecipe = recipeService.saveRecipe(recipe);
        return ResponseEntity
                .ok()
                .body(newRecipe);
    }

    @DeleteMapping(path = "/deleteRecipe/{recipeID}")
    public ResponseEntity<Recipes> removeRecipe(@PathVariable("recipeID")Integer recipeId) {
        Recipes recipeToDelete = recipeService.removeRecipe(recipeId);
        return ResponseEntity
                .ok()
                .body(recipeToDelete);
    }

    @PutMapping()
    public void updateRecipe(Recipes recipe) {
        recipeService.updateRecipe(recipe);
    }
}
