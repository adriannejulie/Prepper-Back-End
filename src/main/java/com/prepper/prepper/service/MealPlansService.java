package com.prepper.prepper.service;

import com.prepper.prepper.model.MealPlans;
import com.prepper.prepper.repository.MealPlansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MealPlansService {
    // variable for service, allows calls to database to be made
    @Autowired
    private MealPlansRepository mpRepository;

    /**
     *  Retrieves all meal plans given a date
     *
     * @param date
     * @return A list of meal plans
     */
    public List<MealPlans> getMealPlansByDate(LocalDate date) {
        return mpRepository.getByDate(date);
    }

    /**
     *  Add a meal plan into database
     *
     * @param mealPlan The meal plan to add
     * @return Saved meal plan
     */
    public MealPlans saveMealPlan(MealPlans mealPlan) {
        return mpRepository.save(mealPlan);
    }

    /**
     *  Remove meal plan given mealPlanID
     *
     * @param mealPlanID MealPlanID to be removed
     * @return Referenced mealPlan
     */
    public Optional<MealPlans> deleteMealPlan(Integer mealPlanID) {
        Optional<MealPlans> planToDelete = mpRepository.findById(mealPlanID);
        mpRepository.deleteById(mealPlanID);
        return planToDelete;
    }

    /**
     *  Retrieves all meal plans given userID
     *
     * @param userID
     * @return A list of meal plans
     */
    public List<MealPlans> getMealPlansByUser(Integer userID) {
        return mpRepository.getByUserID(userID);
    }

    /**
     *  Retrieves all meal plans recipeID
     *
     * @param recipeID
     * @return A list of meal plans
     */
    // function to get meal plans by recipe id
    public List<MealPlans> getMealPlansByRecipe(Integer recipeID) {
        return mpRepository.getByRecipeID(recipeID);
    }
}
