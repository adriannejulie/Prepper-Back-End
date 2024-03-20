package com.prepper.prepper.service;

import com.prepper.prepper.model.MealPlans;
import com.prepper.prepper.repository.MealPlansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MealPlansService {
    // variable for service, allows calls to database to be made
    @Autowired
    private MealPlansRepository mpRepository;

    // function to get all the meal plans by a specific date
    public List<MealPlans> getMealPlansByDate(LocalDate date) {
        return mpRepository.getByDate(date);
    }

    // function to add meal plan to database
    public MealPlans saveMealPlan(MealPlans mealPlan) {
        return mpRepository.save(mealPlan);
    }

    // function to delete a meal plan from the database
    public MealPlans deleteMealPlan(Integer mealPlanID) {
        MealPlans planToDelete = mpRepository.getReferenceById(mealPlanID);
        mpRepository.deleteById(mealPlanID);
        return planToDelete;
    }
}
