package com.prepper.prepper.service;

import com.prepper.prepper.model.Recipes;
import com.prepper.prepper.model.SavedRecipes;
import com.prepper.prepper.repository.SavedRecipesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SavedRecipesServiceTest {

    private Recipes recipe1;
    private Recipes recipe2;
    private List<SavedRecipes> savedRecipesByUser3;

    private List<Recipes> actualSavedRecipes;

    private List<SavedRecipes> recipesByID2;


    @Mock
    SavedRecipesRepository savedRecipesRepository;

    @Mock
    RecipesService recipesService;

    @InjectMocks
    SavedRecipesService savedRecipesService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        recipe1 = new Recipes("image1.jpg", "Recipe 1", "Measurements 1", "Ingredients 1",
                "Description 1", "Instructions 1", "30", "500",
                1, true, 1);


        recipe2 = new Recipes("image3.jpg", "Recipe 3", "Measurements 3", "Ingredients 3",
                "Description 3", "Instructions 3", "10", "100",
                1, true, 2);

        SavedRecipes sr1 = new SavedRecipes(1, 1);
        SavedRecipes sr2 = new SavedRecipes(2, 2);
        SavedRecipes sr3 = new SavedRecipes(2, 4);

        savedRecipesByUser3 = Arrays.asList(sr1, sr2);

        recipesByID2 = Arrays.asList(sr2, sr3);

        actualSavedRecipes = Arrays.asList(recipe1, recipe2);

    }

    @Test
    public void getSavedRecipes_Should_Return_RecipesSavedByUserId3() {
        when(savedRecipesRepository.findByUserID(3)).thenReturn(savedRecipesByUser3);
        when(recipesService.getRecipe(1)).thenReturn(recipe1);
        when(recipesService.getRecipe(2)).thenReturn(recipe2);

        List<Recipes> results = savedRecipesService.getSavedRecipes(3);
        assertEquals(actualSavedRecipes, results);

    }

    @Test
    public void getSavedRecipes_Should_Return_RecipesSavedByUserId2() {
        List<SavedRecipes> emptyList = new ArrayList<>();
        when(savedRecipesRepository.findByUserID(2)).thenReturn(emptyList);

        List<Recipes> results = savedRecipesService.getSavedRecipes(2);
        assertEquals(new ArrayList<>(), results);

    }

    @Test
    public void saveARecipe_Should_Return_SavedRecipe() {
        Recipes updatedRecipe = recipe1 = new Recipes("image1.jpg", "Recipe 1", "Measurements 1", "Ingredients 1",
                "Description 1", "Instructions 1", "30", "500",
                2, true, 1);
        SavedRecipes savedRecipe = new SavedRecipes(1, 4);

        when(recipesService.getRecipe(1)).thenReturn(recipe1);
        when(recipesService.updateRecipe(recipe1)).thenReturn(updatedRecipe);
        when(savedRecipesRepository.save(savedRecipe)).thenReturn(savedRecipe);

        SavedRecipes result = savedRecipesService.saveRecipe(savedRecipe);

        verify(recipesService).getRecipe(1);
        verify(recipesService).updateRecipe(updatedRecipe);
        verify(savedRecipesRepository).save(savedRecipe);

        assertEquals(savedRecipe, result);
    }

    @Test
    public void getSavedRecipesByUser3() {
        when(savedRecipesRepository.findByUserID(3)).thenReturn(savedRecipesByUser3);

        List<SavedRecipes> results = savedRecipesService.getSavedRecipesByUser(3);

        assertEquals(savedRecipesByUser3, results);
    }

    @Test
    public void getSavedRecipesByRecipeID() {

        when(savedRecipesRepository.findByRecipeID(2)).thenReturn(recipesByID2);

        List<SavedRecipes> results = savedRecipesService.getSavedRecipesByRecipe(2);

        assertEquals(recipesByID2, results);
    }



}
