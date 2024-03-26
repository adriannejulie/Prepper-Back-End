package com.prepper.prepper.service;

import com.prepper.prepper.model.MealPlans;
import com.prepper.prepper.repository.MealPlansRepository;
import net.bytebuddy.asm.Advice;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static javax.swing.text.html.parser.DTDConstants.ID;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.when;

class MealPlansServiceTest {

    @Mock
    private MealPlansRepository mealPlansRepository;

    @InjectMocks MealPlansService mealPlansService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        MealPlans meal1 = new MealPlans(LocalDate.now(), 0, 0, "breakfast");
        MealPlans meal2 = new MealPlans(LocalDate.now(), 0, 1, "lunch");
        MealPlans meal3 = new MealPlans(LocalDate.now(), 0, 2, "dinner");

        meal1.setMealPlanID(500);
        meal2.setMealPlanID(500);
        meal3.setMealPlanID(500);

        mealPlansRepository.save(meal1);
        mealPlansRepository.save(meal2);
        mealPlansRepository.save(meal3);

        List<MealPlans> mealPlansListDateAndUser = new ArrayList<>();
        mealPlansListDateAndUser.add(meal1);
        mealPlansListDateAndUser.add(meal2);
        mealPlansListDateAndUser.add(meal3);


        List<MealPlans> mealPlansListRecipe = new ArrayList<>();
        mealPlansListRecipe.add(meal1);
        when(mealPlansRepository.getByDate(LocalDate.now())).thenReturn(mealPlansListDateAndUser);
        when(mealPlansRepository.getByRecipeID(1)).thenReturn(mealPlansListRecipe);
        when(mealPlansRepository.getByUserID(0)).thenReturn(mealPlansListDateAndUser);


    }

    @Test
    void getMealPlansByDate() {
        List<MealPlans> expectedMealPlans = mealPlansRepository.getByDate(LocalDate.now());
        List<MealPlans> actualMealPlans = mealPlansService.getMealPlansByDate(LocalDate.now());
        assertEquals(expectedMealPlans, actualMealPlans);
    }

    @Test
    void saveMealPlan() {
        MealPlans meal = new MealPlans(LocalDate.now(), 1, 2, "breakfast");
        when(mealPlansRepository.save(meal)).thenReturn(meal);
        MealPlans savedMeal = mealPlansService.saveMealPlan(meal);
        assertNotNull(savedMeal);
    }

    @Test
    void deleteMealPlan() {
        Optional<MealPlans> expectedMealPlan = mealPlansRepository.findById(500);
        Optional<MealPlans> planToDelete = mealPlansService.deleteMealPlan(500);
        assertEquals(planToDelete,expectedMealPlan);
    }

    @Test
    void getMealPlansByUser() {
        List<MealPlans> expectedMealPlans = mealPlansRepository.getByUserID(0);
        List<MealPlans> actualMealPlans = mealPlansService.getMealPlansByUser(0);
        assertEquals(expectedMealPlans, actualMealPlans);
    }

    @Test
    void getMealPlansByRecipe() {
        List<MealPlans> expectedMealPlans = mealPlansRepository.getByRecipeID(1);
        List<MealPlans> actualMealPlans = mealPlansService.getMealPlansByRecipe(1);
        assertEquals(expectedMealPlans, actualMealPlans);

    }
}