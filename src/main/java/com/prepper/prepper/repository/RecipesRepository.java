package com.prepper.prepper.repository;

import com.prepper.prepper.model.Recipes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipesRepository extends JpaRepository<Recipes, Integer> {

    /**
     * Retrieves a Recipes Objects of a specific user
     * @param userId
     * @return List of Recipes Objects
     */
    List<Recipes> findByUserID(Integer userId);

    /**
     * Retrieves all public recipes
     * @param isPublic
     * @return List of Recipe Objects
     */
    List<Recipes> findByIsPublic(Boolean isPublic);

    /**
     * Retrieves a specific recipe
     * @param recipeID
     * @return Recipe Object
     */
    Recipes findByRecipeID(Integer recipeID);
}
