package com.prepper.prepper.repository;

import com.prepper.prepper.model.Recipes;
import com.prepper.prepper.model.SavedRecipes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavedRecipesRepository extends JpaRepository<SavedRecipes, Integer> {

    /**
     * Retrieves all saved recipes of a user
     * @param userId
     * @return List of SavedRecipes Objects
     */
    List<SavedRecipes> findByUserID(Integer userId);

    /**
     * Retrieves all saved recipe with a specific recipeID
     * @param recipeId
     * @return List of SavedRecipes Objects
     */
    List<SavedRecipes> findByRecipeID(Integer recipeId);
}
