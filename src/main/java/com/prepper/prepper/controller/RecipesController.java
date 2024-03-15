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

    @GetMapping("/getRecipes")
    public List<Recipes> getRecipes() {
        return recipeService.getRecipes();
    }

    @PostMapping("/addRecipe")
    public void addRecipe(@RequestBody Recipes recipe) {

        Recipes newRecipe = recipeService.saveRecipe(recipe);
    }

    @DeleteMapping(path = "{recipeId}")
    public void removeRecipe(
            @PathVariable("recipeId")Long recipeId) {
        recipeService.removeRecipe(recipeId);
    }
}
