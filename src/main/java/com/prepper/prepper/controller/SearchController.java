package com.prepper.prepper.controller;

import com.prepper.prepper.model.Recipes;
import com.prepper.prepper.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@CrossOrigin("http://localhost:3000")
public class SearchController {
    @Autowired
    private SearchService searchService;

    @GetMapping("/search")
    public ResponseEntity<List<Recipes>> getRecipeByIngredient(@RequestBody List<String> ingredients) {
        List<Recipes> recipes = new ArrayList<>();
        for (String ingredient : ingredients) {
            List<Recipes> search = searchService.getRecipeByIngredient(ingredient);
            recipes.addAll(search);
        }
        if ( recipes.isEmpty() ) {
            return ResponseEntity
                    .badRequest()
                    .header("No recipe found")
                    .build();
        } else {
            return ResponseEntity
                    .ok()
                    .body(recipes);
        }
    }
}
