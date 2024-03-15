package com.prepper.prepper.controller;

import com.prepper.prepper.model.Recipes;
import com.prepper.prepper.service.RecipesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class RecipesController {

    @Autowired
    private RecipesService recipeService;

    @GetMapping("/getRecipes/{userID}")
    public List<Recipes> getRecipesByUser(@PathVariable Integer userID) {
        return recipeService.getRecipesByUser(userID);
    }

    @GetMapping("getPublicRecipes")
    public List<Recipes> getPublicRecipes() {
        return recipeService.getPublicRecipes();
    }

    @GetMapping("/getRecipe/{recipeID}")
    public Recipes getRecipe(@PathVariable Integer recipeID) {

        return recipeService.getRecipe(recipeID);
    }

    @PostMapping("/addRecipe")
    public void addRecipe(@RequestBody Recipes recipe) {

        Recipes newRecipe = recipeService.saveRecipe(recipe);
    }

    @DeleteMapping(path = "{recipeID}")
    public void removeRecipe(
            @PathVariable("recipeID")Integer recipeId) {
        recipeService.removeRecipe(recipeId);
    }
}
