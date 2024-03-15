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

    public List<Recipes> getRecipesByUser(Integer userId) {

        return recipesRepository.findByUserID(userId);
    }

    public Recipes getRecipe(Integer recipeId) {

        return recipesRepository.findByRecipeID(recipeId);
    }

    public List<Recipes> getPublicRecipes() {
        return recipesRepository.findByIsPublic(true);
    }
    public Recipes saveRecipe(Recipes recipe) {
        return recipesRepository.save(recipe);
    }

    public void removeRecipe(Integer recipeId) {
        boolean exists = recipesRepository.existsById(recipeId);
        if (!exists) {
            throw new IllegalStateException(
                    "Recipe with id " + recipeId + " does not exists"
            );
        }
        recipesRepository.deleteById(recipeId);
    }
}
