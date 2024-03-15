package com.prepper.prepper.repository;

import com.prepper.prepper.model.SavedRecipes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavedRecipesRepository extends
        JpaRepository<SavedRecipes, Integer> {
}
