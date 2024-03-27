package com.prepper.prepper.service;

import com.prepper.prepper.model.Recipes;
import com.prepper.prepper.repository.RecipesRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SearchService {
    RecipesRepository recipesRepository;

    /**
     * Retrieves all recipes given ingredient
     *
     * @param ingredient The ingredient to search for
     * @return A list of recipes containing the given ingredient
     */
    public List<Recipes> getRecipeByIngredient(String ingredient) {
        List<Recipes> allRecipes = new ArrayList<>();
        allRecipes = recipesRepository.findAll();
        List<Recipes> filteredRecipes = new ArrayList<>();
        for (Recipes recipes : allRecipes) {
            if (recipes.getIngredients().contains(ingredient)){
                filteredRecipes.add(recipes);
            }
        }
        return filteredRecipes;
    }

}
