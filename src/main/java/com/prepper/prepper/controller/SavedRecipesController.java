package com.prepper.prepper.controller;

import com.prepper.prepper.model.Recipes;
import com.prepper.prepper.model.SavedRecipes;
import com.prepper.prepper.service.SavedRecipesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class SavedRecipesController {

    @Autowired
    private SavedRecipesService savedRecipeService;

    @GetMapping("/getSavedRecipes/{userID}")
    public List<Recipes> getSavedRecipe(@PathVariable Integer userID) {

        return savedRecipeService.getSavedRecipes(userID);
    }

    @PostMapping("/addSavedRecipe")
    public void addSavedRecipe(@RequestBody SavedRecipes saveRecipe  ) {
        SavedRecipes newSavedRecipe = savedRecipeService.saveRecipe(saveRecipe);


    }
    @DeleteMapping(path = "/removeSavedRecipe/{userID}-{recipeID}")
    public void removeRecipe(
            @PathVariable("userID") Integer userId,
            @PathVariable("recipeID")Integer recipeId
            ) {
        savedRecipeService.removeSavedRecipe(userId, recipeId);
    }
}
