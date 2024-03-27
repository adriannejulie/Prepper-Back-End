package com.prepper.prepper.repository;

import com.prepper.prepper.model.MealPlans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MealPlansRepository extends JpaRepository<MealPlans, Integer> {
    /**
     * Retrieves all MealPlans objects of a specific date
     * @param date
     * @return List of MealPlans Objects
     */
    List<MealPlans> getByDate(LocalDate date);

    /**
     * Retrieves all MealPlans objects of a corresponding User
     * @param userID
     * @return List of MealPlans Objects
     */
    List<MealPlans> getByUserID(Integer userID);

    /**
     * Retrieves all MealPlans objects of a specific recipe
     * @param recipeID
     * @return List of MealPlans objects
     */
    List<MealPlans> getByRecipeID(Integer recipeID);
}
