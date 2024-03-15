package com.prepper.prepper.repository;

import com.prepper.prepper.model.Recipes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipesRepository
        extends JpaRepository<Recipes, Integer> {

    List<Recipes> findByUserID(Integer userId);

    List<Recipes> findByIsPublic(Boolean isPublic);

    Recipes findByRecipeID(Integer recipeID);
}
