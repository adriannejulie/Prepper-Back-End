package com.prepper.prepper.repository;

import com.prepper.prepper.model.Recipes;
import com.prepper.prepper.model.SavedRecipes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavedRecipesRepository extends
        JpaRepository<SavedRecipes, Integer> {

    List<SavedRecipes> findByUserID(Integer userId);

    List<SavedRecipes> findByRecipeID(Integer recipeId);
}
