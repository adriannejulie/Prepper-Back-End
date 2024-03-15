package com.prepper.prepper.controller;

import com.prepper.prepper.model.MealPlans;
import com.prepper.prepper.service.MealPlansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class MealPlansController {
    // variable for service, allows calls to database to be made
    @Autowired
    private MealPlansService mpService;

    // function API to get meal plans by date
    @GetMapping("/getMealPlans/{date}")
    public List<MealPlans> getMealPlans(@PathVariable String date){
        LocalDate transformedDate = LocalDate.parse(date);
        return mpService.getMealPlansByDate(transformedDate);
    }

    // function API to add meal plan to database
    @PostMapping("/addMealPlan")
    public MealPlans addMealPlan(@RequestBody MealPlans mealPlan) {
        return mpService.saveMealPlan(mealPlan);
    }

    @DeleteMapping("/removeMealPlan/{mealPlanID}")
    public void removeMealPlan(@PathVariable("mealPlanID") Integer mealPlanID) {
        mpService.deleteMealPlan(mealPlanID);
    }
}
