package com.prepper.prepper.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.prepper.prepper.model.Recipes;
import com.prepper.prepper.model.SavedRecipes;
import com.prepper.prepper.service.RecipesService;
import com.prepper.prepper.service.SavedRecipesService;

public class SavedRecipeRepositoryTest {

    @Mock
    SavedRecipesRepository savedRecipesRepository;
    List<SavedRecipes> recipesOne;
    List<SavedRecipes> recipesTwo;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        Recipes recipe1 = new Recipes("image1.jpg", "Recipe 1", "Measurements 1", "Ingredients 1",
                "Description 1", "Instructions 1", "30", "500",
                1, true, 1);

        Recipes recipe2 = new Recipes("image3.jpg", "Recipe 3", "Measurements 3", "Ingredients 3",
                "Description 3", "Instructions 3", "10", "100",
                1, true, 2);

        recipe1.setRecipeID(1);
        recipe2.setRecipeID(2);

        SavedRecipes sr1 = new SavedRecipes(1, 1);
        SavedRecipes sr2 = new SavedRecipes(2, 2);
        SavedRecipes sr3 = new SavedRecipes(2, 4);

        List<SavedRecipes> recipes1 = new ArrayList<>();
        recipes1.add(sr1);

        List<SavedRecipes> recipes2 = new ArrayList<>();
        recipes2.add(sr2);
        recipes2.add(sr3);

        this.recipesOne = recipes1;
        this.recipesTwo = recipes2;

        when(savedRecipesRepository.findByUserID(1)).thenReturn(recipes1);

        when(savedRecipesRepository.findByRecipeID(1)).thenReturn(recipes1);
        when(savedRecipesRepository.findByRecipeID(2)).thenReturn(recipes2);
    }

    @Test
    public void findByUserIDTest_singular(){
        List<SavedRecipes> expected = recipesOne;
        List<SavedRecipes> actual = savedRecipesRepository.findByUserID(1);
        assertEquals(expected,actual);
    }

    @Test
    public void findByUserIDTest_differentUserIDs(){
        List<SavedRecipes> expected = recipesTwo;
        List<SavedRecipes> actual = savedRecipesRepository.findByUserID(2);
        assertNotEquals(expected,actual);
    }

    @Test
    public void findByUserIDTest_noUser(){
        List<SavedRecipes> expected = new ArrayList<>();
        List<SavedRecipes> actual = savedRecipesRepository.findByUserID(5);
        assertEquals(expected, actual);
    }

    @Test
    public void findByRecipeIDTest_singular(){
        List<SavedRecipes> expected = recipesOne;
        List<SavedRecipes> actual = savedRecipesRepository.findByRecipeID(1);
        assertEquals(expected,actual);
    }

    @Test
    public void findByRecipeIDTest_MultipleRecipeIDs(){
        List<SavedRecipes> expected = recipesTwo;
        List<SavedRecipes> actual = savedRecipesRepository.findByRecipeID(2);
        assertEquals(expected,actual);
    }

    @Test
    public void findByRecipeIDTest_noRecipe(){
        List<SavedRecipes> expected = new ArrayList<>();
        List<SavedRecipes> actual = savedRecipesRepository.findByRecipeID(5);
        assertEquals(expected, actual);
    }
}
