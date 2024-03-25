package com.prepper.prepper.controller;

import com.prepper.prepper.model.Recipes;
import com.prepper.prepper.service.SavedRecipesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RecipesController.class)
public class SavedRecipesControllerTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private SavedRecipesService savedRecipesService;
//
//    @Test
//    public void testGetSavedRecipesByUserID() throws Exception {
//        Integer userId = 1;
//        List<Recipes> mockRecipes = Arrays.asList(
//                new Recipes("image1.jpg", "Recipe 1", "Measurements 1", "Ingredients 1",
//                        "Description 1", "Instructions 1", "30", "500",
//                        10, true, 2),
//                new Recipes("image2.jpg", "Recipe 2", "Measurements 2", "Ingredients 2",
//                        "Description 2", "Instructions 2", "45", "700",
//                        5, false, 3)
//        );
//        when(savedRecipesService.getSavedRecipes(userId)).thenReturn(mockRecipes);
//
//        mockMvc.perform(get("/getSavedRecipes/{userID}", userId))
//                .andExpect(status().isOk());
//    }
}
