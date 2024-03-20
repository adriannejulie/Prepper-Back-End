package com.prepper.prepper.controller;

import com.prepper.prepper.model.MealPlans;
import com.prepper.prepper.service.MealPlansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class MealPlansController {
    // variable for service, allows calls to database to be made
    @Autowired
    private MealPlansService mpService;

    // function API to get meal plans by date
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

    // function API to add meal plan to database
    @PostMapping("/addMealPlan")
    public ResponseEntity<MealPlans> addMealPlan(@RequestBody MealPlans mealPlan) {
        MealPlans planToAdd = mpService.saveMealPlan(mealPlan);
        return ResponseEntity
                .ok()
                .body(planToAdd);
    }

    @DeleteMapping("/removeMealPlan/{mealPlanID}")
    public ResponseEntity<MealPlans> removeMealPlan(@PathVariable("mealPlanID") Integer mealPlanID) {
        MealPlans planToDelete =  mpService.deleteMealPlan(mealPlanID);
        return ResponseEntity
                .ok()
                .body(planToDelete);
    }
}
