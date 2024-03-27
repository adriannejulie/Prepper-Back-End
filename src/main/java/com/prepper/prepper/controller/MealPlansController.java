package com.prepper.prepper.controller;

import com.prepper.prepper.model.MealPlans;
import com.prepper.prepper.service.MealPlansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
public class MealPlansController {
    // variable for service, allows calls to database to be made
    @Autowired
    private MealPlansService mpService;

    /**
     * Retrieves all meal plans for a specific date
     * 
     * @param date
     * @param userID
     * @return A list of Meal Plans and a Response Entity code
     */
    @GetMapping("/getMealPlans/{date}/{userID}")
    public ResponseEntity<List<MealPlans>> getMealPlans(@PathVariable String date, @PathVariable Integer userID){
        LocalDate transformedDate = LocalDate.parse(date);
        List<MealPlans> allPlans = mpService.getMealPlansByDate(transformedDate);
        ArrayList<MealPlans> userPlans = new ArrayList<MealPlans>();
        for (MealPlans plan : allPlans) {
            if (plan.getUserID().equals(userID)) {
                userPlans.add(plan);
            }
        }
        return ResponseEntity
                .ok()
                .body(userPlans);
    }

    /**
     * Adds a new meal plan
     * 
     * @param mealPlan
     * @return Meal plan object and a Response Entity code 200
     */
    @PostMapping("/addMealPlan")
    public ResponseEntity<MealPlans> addMealPlan(@RequestBody MealPlans mealPlan) {
        MealPlans planToAdd = mpService.saveMealPlan(mealPlan);
        return ResponseEntity
                .ok()
                .body(planToAdd);
    }

    /**
     * Deletes a meal plan
     * 
     * @param mealPlanID
     * @return MealPlan object that was deleted and a Response Entity code 200
     */
    @DeleteMapping("/removeMealPlan/{mealPlanID}")
    public ResponseEntity<Optional<MealPlans>> removeMealPlan(@PathVariable("mealPlanID") Integer mealPlanID) {
        Optional<MealPlans> planToDelete =  mpService.deleteMealPlan(mealPlanID);
        return ResponseEntity
                .ok()
                .body(planToDelete);
    }

    /**
     * Updates MealPlan variables
     * 
     * @param mealPlan
     * @param mealPlanID
     * @return Updated MealPlan object and a Response Entity code 200
     */
    @PutMapping("/editMealPlan/{mealPlanID}")
    public ResponseEntity<MealPlans> editMealPlan(@RequestBody MealPlans mealPlan, @PathVariable Integer mealPlanID) {
        MealPlans updatedMealPlan = mpService.saveMealPlan(mealPlan);
        return ResponseEntity
                .ok()
                .body(updatedMealPlan);
    }
}
