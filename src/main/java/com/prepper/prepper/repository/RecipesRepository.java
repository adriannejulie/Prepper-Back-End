package com.prepper.prepper.repository;

import com.prepper.prepper.model.Recipes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipesRepository
        extends JpaRepository<Recipes, Integer> {


}
