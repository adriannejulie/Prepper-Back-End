package com.prepper.prepper.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.prepper.prepper.model.MealPlans;

public class MealPlansRepositoryTest {

    @Mock
    private MealPlansRepository mealPlansRepository;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        MealPlans meal1 = new MealPlans(LocalDate.now(), 0, 0, "breakfast");
        MealPlans meal2 = new MealPlans(LocalDate.now(), 0, 1, "lunch");
        MealPlans meal3 = new MealPlans(LocalDate.now(), 0, 2, "dinner");

        mealPlansRepository.save(meal1);
        mealPlansRepository.save(meal2);
        mealPlansRepository.save(meal3);

    }
    
    @Test
    public void getByDateTest(){
        List<MealPlans> expectedList = mealPlansRepository.findAll();
        List<MealPlans> actualList = mealPlansRepository.getByDate(LocalDate.now());
        assertEquals(expectedList, actualList);
    }

    @Test
    public void getByUserIDTest(){
        List<MealPlans> expectedList = mealPlansRepository.findAll();
        List<MealPlans> actualList = mealPlansRepository.getByUserID(0);
        assertEquals(expectedList, actualList);
    }

    @Test
    public void getByRecipeID(){
        List<MealPlans> expectedList = new ArrayList<>();
        MealPlans meal3 = new MealPlans(LocalDate.now(), 0, 2, "dinner");
        expectedList.add(meal3);
        when(mealPlansRepository.getByRecipeID(2)).thenReturn(expectedList);
        List<MealPlans> actualList = mealPlansRepository.getByRecipeID(2);
        assertEquals(expectedList, actualList);    
    }
}
