package com.prepper.prepper.service;

import com.prepper.prepper.model.Recipes;
import com.prepper.prepper.repository.RecipesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RecipesServiceTest {

    private Recipes recipe1;
    private Recipes recipe2;
    private List<Recipes> recipesByUser1;
    private List<Recipes> publicRecipes;
    @Mock
    RecipesRepository recipesRepository;

    @InjectMocks
    RecipesService recipesService;

    @BeforeEach
    public void setUp() {

        MockitoAnnotations.openMocks(this);

        recipe1 = new Recipes("image1.jpg", "Recipe 1", "Measurements 1", "Ingredients 1",
                "Description 1", "Instructions 1", "30", "500",
                0, true, 1);

        recipe2 = new Recipes("image2.jpg", "Recipe 2", "Measurements 2", "Ingredients 2",
                "Description 2", "Instructions 2", "45", "700",
                0, false, 1);

        Recipes recipe3 = new Recipes("image3.jpg", "Recipe 3", "Measurements 3", "Ingredients 3",
                "Description 3", "Instructions 3", "10", "100",
                0, true, 2);

        recipesByUser1 = Arrays.asList(recipe1, recipe2);
        publicRecipes = Arrays.asList(recipe1, recipe3);


        when(recipesRepository.findByUserID(1)).thenReturn(recipesByUser1);
        when(recipesRepository.findByRecipeID(1)).thenReturn(recipe1);
        when(recipesRepository.findByIsPublic(true)).thenReturn(publicRecipes);
    }

    @Test
    public void getRecipeByUser1_Should_Return_All_Recipes_By_User() {
        List<Recipes> result = recipesService.getRecipesByUser(1);
        assertEquals(recipesByUser1, result);
    }

    @Test
    public void getRecipeByUser2_Should_Return_EmptyList() {
        List<Recipes> result = recipesService.getRecipesByUser(2);
        List<Recipes> emptyList = new ArrayList<>();
        assertEquals(result, emptyList);
    }

    @Test
    public void getRecipeByRecipeID1_Should_Return_Recipe1() {
        Recipes result = recipesService.getRecipe(1);
        assertEquals(recipe1, result);
    }

    @Test
    public void getRecipeByRecipeID3_Should_Return_EmptyObject() {
        Recipes result = recipesService.getRecipe(3);
        assertNull(result);
    }

    @Test
    public void getPublicRecipes_Should_Return_All_Public_Recipes() {
        List<Recipes> result = recipesService.getPublicRecipes();
        assertEquals(publicRecipes, result);
    }

    @Test
    public void saveRecipe_Should_Return_Saved_Recipe() {
        Recipes newRecipe = new Recipes("imageNew.jpg", "Recipe New", "Measurements New", "Ingredients New",
                "Description New", "Instructions New", "5", "50",
                0, true, 3);

        when(recipesRepository.save(newRecipe)).thenReturn(newRecipe);

        Recipes result = recipesService.saveRecipe(newRecipe);
        assertEquals(newRecipe, result);
    }

    @Test
    public void removedRecipe_NotFound() {

        doThrow(new IllegalStateException("Recipe with any int does not exist")).when(recipesRepository).deleteById(anyInt());

        // Call the method under test and catch the exception
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            recipesService.removeRecipe(1);
        });

        // Verify the exception message
        assertEquals("Recipe with id 1 does not exists", exception.getMessage());
    }

    @Test
    public void updateRecipe_Should_Return_UpdatedRecipe() {

        Recipes updatedRecipe = new Recipes("image2.jpg", "Recipe 2-2", "Measurements 2", "Ingredients 2",
                "Description 2", "Instructions 2", "15", "70",
                0, false, 1);

        when(recipesRepository.save(updatedRecipe)).thenReturn(updatedRecipe);
        when(recipesRepository.findByRecipeID(recipe2.getRecipeID())).thenReturn(updatedRecipe);

        Recipes update = recipesService.updateRecipe(updatedRecipe);

        assertEquals(updatedRecipe, update);
    }
}
