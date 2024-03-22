package com.prepper.prepper.config;

import com.prepper.prepper.model.SavedRecipes;
import com.prepper.prepper.repository.RecipesRepository;
import com.prepper.prepper.repository.SavedRecipesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SavedRecipesConfig {

    @Bean
    CommandLineRunner commandLineRunner3(
            SavedRecipesRepository repository) {
        return args -> {
            SavedRecipes saved1 = new SavedRecipes(
                    2,
                    1
            );
            SavedRecipes saved2 = new SavedRecipes(
                    5,
                    1
            );
            SavedRecipes saved3 = new SavedRecipes(
                    5,
                    2
            );

            SavedRecipes saved4 = new SavedRecipes(
                    7,
                    2
            );

            SavedRecipes saved5 = new SavedRecipes(
                    7,
                    3
            );

            SavedRecipes saved6 = new SavedRecipes(
                    7,
                    4
            );

            SavedRecipes saved7 = new SavedRecipes(
                    8,
                    1
            );
            repository.saveAll(
                    List.of(saved1, saved2, saved3, saved4, saved5, saved6, saved7)
            );
        };
    }
}
