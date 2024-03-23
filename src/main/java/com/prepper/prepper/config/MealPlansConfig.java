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
                    LocalDate.parse("2024-03-01"),
                    1,
                    3,
                    "breakfast"
            );

            MealPlans meal2 = new MealPlans(
                    LocalDate.parse("2024-03-01"),
                    1,
                    1,
                    "lunch"
            );

            MealPlans meal3 = new MealPlans(
                    LocalDate.parse("2024-03-01"),
                    1,
                    2,
                    "dinner"
            );

            MealPlans meal4 = new MealPlans(
                    LocalDate.parse("2024-03-02"),
                    2,
                    3,
                    "breakfast"
            );

            MealPlans meal5 = new MealPlans(
                    LocalDate.parse("2024-03-05"),
                    2,
                    2,
                    "lunch"
            );

            MealPlans meal6 = new MealPlans(
                    LocalDate.parse("2024-03-02"),
                    2,
                    1,
                    "lunch"
            );

            MealPlans meal7 = new MealPlans(
                    LocalDate.parse("2024-03-02"),
                    2,
                    2,
                    "dinner"
            );

            MealPlans meal8 = new MealPlans(
                    LocalDate.parse("2024-03-03"),
                    3,
                    1,
                    "breakfast"
            );

            MealPlans meal9 = new MealPlans(
                    LocalDate.parse("2024-03-03"),
                    3,
                    3,
                    "lunch"
            );

            MealPlans meal10 = new MealPlans(
                    LocalDate.parse("2024-03-03"),
                    3,
                    2,
                    "dinner"
            );

            MealPlans meal11 = new MealPlans(
                    LocalDate.parse("2024-03-04"),
                    4,
                    1,
                    "breakfast"
            );

            MealPlans meal12 = new MealPlans(
                    LocalDate.parse("2024-03-04"),
                    4,
                    2,
                    "lunch"
            );

            MealPlans meal13 = new MealPlans(
                    LocalDate.parse("2024-03-04"),
                    4,
                    3,
                    "dinner"
            );

            MealPlans meal14 = new MealPlans(
                    LocalDate.parse("2024-03-05"),
                    5,
                    1,
                    "breakfast"
            );

            MealPlans meal15 = new MealPlans(
                    LocalDate.parse("2024-03-05"),
                    5,
                    2,
                    "dinner"
            );

            repository.saveAll(
                    List.of(meal1, meal2, meal3, meal4, meal5, meal6, meal7, meal8, meal9, meal10, meal11, meal12, meal13, meal14, meal15)
            );

        };
        }

}
