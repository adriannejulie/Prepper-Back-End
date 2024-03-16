package com.prepper.prepper.config;

import com.prepper.prepper.model.MealPlans;
import com.prepper.prepper.repository.MealPlansRepository;
import com.prepper.prepper.repository.RecipesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class MealPlansConfig {
    @Bean
    CommandLineRunner commandLineRunner4(
            MealPlansRepository repository) {
        return args -> {
            MealPlans meal1 = new MealPlans(
                    LocalDate.parse("2021-03-01"),
                    1,
                    3,
                    "breakfast"
            );

            MealPlans meal2 = new MealPlans(
                    LocalDate.parse("2021-03-01"),
                    1,
                    1,
                    "lunch"
            );

            MealPlans meal3 = new MealPlans(
                    LocalDate.parse("2021-03-01"),
                    1,
                    2,
                    "dinner"
            );

            MealPlans meal4 = new MealPlans(
                    LocalDate.parse("2021-03-02"),
                    2,
                    3,
                    "breakfast"
            );

            MealPlans meal5 = new MealPlans(
                    LocalDate.parse("2021-03-05"),
                    2,
                    2,
                    "lunch"
            );
            repository.saveAll(
                    List.of(meal1, meal2, meal3, meal4, meal5)
            );
        };
        }

}
