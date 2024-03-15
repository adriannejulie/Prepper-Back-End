package com.prepper.prepper.service;

import com.prepper.prepper.model.SavedRecipes;
import com.prepper.prepper.repository.SavedRecipesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavedRecipesService {
    @Autowired
    private SavedRecipesRepository savedRecipesRepository;

    public List<SavedRecipes> getSavedRecipes() {
        return savedRecipesRepository.findAll();
    }
    public SavedRecipes saveRecipe(SavedRecipes savedRecipe) {
        return savedRecipesRepository.save(savedRecipe);
    }

//    public void removeSavedRecipe(Integer userId, Integer recipeId) {
//        boolean exists = SavedRecipesRepository.exist
//        if (!exists) {
//            throw new IllegalStateException(
//                    "Recipe with id " + recipeId + " does not exists"
//            );
//        }
//        SavedRecipesRepository.deleteById(recipeId);
//    }
}
