package com.prepper.prepper.service;

import com.prepper.prepper.model.Recipes;
import com.prepper.prepper.repository.RecipesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipesService {
    @Autowired
    private RecipesRepository recipesRepository;

    public List<Recipes> getRecipes() {
        return recipesRepository.findAll();
    }
    public Recipes saveRecipe(Recipes recipe) {
//        Optional<Recipe> recipeByID = recipeRepository.findRecipeByID(recipe.getID());
        return recipesRepository.save(recipe);
    }

    public void removeRecipe(Long recipeId) {
        boolean exists = recipesRepository.existsById(recipeId);
        if (!exists) {
            throw new IllegalStateException(
                    "Recipe with id " + recipeId + " does not exists"
            );
        }
        recipesRepository.deleteById(recipeId);
    }
}
