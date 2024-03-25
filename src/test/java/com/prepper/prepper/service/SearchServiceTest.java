package com.prepper.prepper.service;

import com.prepper.prepper.model.Recipes;
import com.prepper.prepper.repository.RecipesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchServiceTest {

    private List<Recipes> recipeList;

    private List<Recipes> matchedList;
    @Mock
    RecipesRepository recipesRepository;

    @InjectMocks
    SearchService searchService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        Recipes recipe1 = new Recipes("image1.jpg", "Recipe 1", "Measurements 1", "flour, sugar, egg",
                "Description 1", "Instructions 1", "30", "500",
                0, true, 1);

        Recipes recipe2 = new Recipes("image2.jpg", "Recipe 2", "Measurements 2", "flour, egg",
                "Description 2", "Instructions 2", "45", "700",
                0, true, 1);

        Recipes recipe3 = new Recipes("image3.jpg", "Recipe 3", "Measurements 3", "egg, pancake mix",
                "Description 3", "Instructions 3", "10", "100",
                0, true, 2);

        recipeList = Arrays.asList(recipe1, recipe2, recipe3);

        matchedList = Arrays.asList(recipe1, recipe2);

        when(recipesRepository.findAll()).thenReturn(recipeList);
    }

    @Test
    public void getRecipeByIngredient_Should_Return_RecipeList_That_Contains_Ingredient() {

        List<Recipes> results = searchService.getRecipeByIngredient("flour");

        assertEquals(matchedList, results);
    }

    @Test
    public void getRecipeByIngredient_Should_Return_EmptyList() {

        List<Recipes> results = searchService.getRecipeByIngredient("baking powder");

        List<Recipes> emptyList = new ArrayList<>();

        assertEquals(emptyList, results);
    }
}
