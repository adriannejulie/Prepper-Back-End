package com.prepper.prepper.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.prepper.prepper.model.MealPlans;
import com.prepper.prepper.model.Recipes;
import com.prepper.prepper.model.Users;
import com.prepper.prepper.service.RecipesService;

public class RecipesRepositoryTest {

    @Mock
    RecipesRepository recipesRepository;


    @BeforeEach
    public void setUp() {

        MockitoAnnotations.openMocks(this);

        Recipes recipe1 = new Recipes("image1.jpg", "Recipe 1", "Measurements 1", "Ingredients 1",
                "Description 1", "Instructions 1", "30", "500",
                0, true, 1);

        Recipes recipe2 = new Recipes("image2.jpg", "Recipe 2", "Measurements 2", "Ingredients 2",
                "Description 2", "Instructions 2", "45", "700",
                0, false, 1);

        Recipes recipe3 = new Recipes("image3.jpg", "Recipe 3", "Measurements 3", "Ingredients 3",
                "Description 3", "Instructions 3", "10", "100",
                0, true, 2);

        recipesRepository.save(recipe1);
        recipesRepository.save(recipe2);
        recipesRepository.save(recipe3);

    }

    @Test
    public void findByUserIDTest(){
        List<Recipes> expectedList = new ArrayList<>();
        Recipes recipe1 = new Recipes("image1.jpg", "Recipe 1", "Measurements 1", "Ingredients 1",
                "Description 1", "Instructions 1", "30", "500",
                0, true, 1);

        Recipes recipe2 = new Recipes("image2.jpg", "Recipe 2", "Measurements 2", "Ingredients 2",
                "Description 2", "Instructions 2", "45", "700",
                0, false, 1);
        expectedList.add(recipe1);
        expectedList.add(recipe2);
        when(recipesRepository.findByUserID(1)).thenReturn(expectedList);
        List<Recipes> actualList = recipesRepository.findByUserID(1);
        assertEquals(expectedList, actualList);
    }

    @Test
    public void findByIsPublicTest(){
        List<Recipes> expectedList = new ArrayList<>();
        Recipes recipe1 = new Recipes("image1.jpg", "Recipe 1", "Measurements 1", "Ingredients 1",
                "Description 1", "Instructions 1", "30", "500",
                0, true, 1);

        Recipes recipe3 = new Recipes("image3.jpg", "Recipe 3", "Measurements 3", "Ingredients 3",
                "Description 3", "Instructions 3", "10", "100",
                0, true, 2);
        expectedList.add(recipe1);
        expectedList.add(recipe3);
        when(recipesRepository.findByIsPublic(true)).thenReturn(expectedList);
        List<Recipes> actualList = recipesRepository.findByIsPublic(true);
        assertEquals(expectedList, actualList);
    }

    @Test
    public void findByRecipeIDTest(){

        Recipes expected = new Recipes("image1.jpg", "Recipe 1", "Measurements 1", "Ingredients 1",
                "Description 1", "Instructions 1", "30", "500",
                0, true, 1);
        expected.setRecipeID(1);

        when(recipesRepository.findByRecipeID(1)).thenReturn(expected);
        Recipes actual = recipesRepository.findByRecipeID(1);
        assertEquals(expected, actual);
        
    }

}
