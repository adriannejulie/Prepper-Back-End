package com.prepper.prepper.config;

import com.prepper.prepper.model.Recipes;
import com.prepper.prepper.repository.RecipesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RecipesConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            RecipesRepository repository) {
        return args -> {
            Recipes pasta = new Recipes(
                    null,
                    "Chicken Alfredo Pasta",
                    "6 ounce, 8 ounce, 6 tbsp, 1/2 cup, 1/2 tsp, 2",
                    "fettuccine pasta, cream cheese, butter, milk, garlic powder, chicken breast(cooked)",
                    "Delicious homemade chicken alfredo",
                    "1. Boil pasta, cook for 8-10 minutes 2. While pasta is cooking, melt cream cheese and butter in skillet over low heat. Stir until smooth. Stir in milk, and season with garlic powder, salt and pepper.",
                    40,
                    645,
                    0,
                    true,
                    1
            );

            Recipes salad = new Recipes(
                    null,
                    "Apple Spinach Salad",
                    "2 cups, 1, 2 tbsp, 2 tbsp, 2 tbsp",
                    "baby spinach, medium apple(sliced), celery(chopped), pecans, dressing",
                    "Healthy green salad",
                    "1. Toss ingredients with dressing in a large bowl",
                    5,
                    100,
                    0,
                    true,
                    2
            );

            Recipes pancake = new Recipes(
                    null,
                    "Buttermilk Pancakes",
                    "1 cup, 1 tsp, 1 tsp, 1, 1 1/8 cup, 2 tbsp, null",
                    "flour, salt, baking soda, large egg, buttermilk, butter(melted), Syrup(Optional)",
                    "Yummy Buttermilk pancakes",
                    "1. Preheat and grease skillet 2. Mix flour, salt, baking soda. Then add egg, buttermilk, and butter. Batter should look thick, spongy, and puffy.  3. Drop 1/3 cup of batter, spread lightly, cook until lightly browned on each side, 1-2 minutes per side.",
                    30,
                    210,
                    0,
                    false,
                    2
            );

            repository.saveAll(
                    List.of(pasta, salad, pancake)
            );
        };
    }
}
