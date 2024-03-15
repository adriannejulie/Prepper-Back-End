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
                    3,
                    1
            );
            repository.saveAll(
                    List.of(saved1, saved2)
            );
        };
    }
}
