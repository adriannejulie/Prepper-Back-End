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
                    "https://res.cloudinary.com/dgabkajhe/image/upload/v1709337647/Screenshot_425_asbwjt.png",
                    "Chicken Alfredo Pasta",
                    "6 ounce, 8 ounce, 6 tbsp, 1/2 cup, 1/2 tsp, 2",
                    "fettuccine pasta, cream cheese, butter, milk, garlic powder, chicken breast(cooked)",
                    "Delicious homemade chicken alfredo",
                    "1. Boil pasta, cook for 8-10 minutes 2. While pasta is cooking, melt cream cheese and butter in skillet over low heat. Stir until smooth. Stir in milk, and season with garlic powder, salt and pepper.",
                    "40",
                    "645",
                    0,
                    true,
                    1
            );

            Recipes salad = new Recipes(
                    "https://res.cloudinary.com/dgabkajhe/image/upload/v1709337647/Screenshot_425_asbwjt.png",
                    "Apple Spinach Salad",
                    "2 cups, 1, 2 tbsp, 2 tbsp, 2 tbsp",
                    "baby spinach, medium apple(sliced), celery(chopped), pecans, dressing",
                    "Healthy green salad",
                    "1. Toss ingredients with dressing in a large bowl",
                    "5",
                    "100",
                    1,
                    true,
                    2
            );

            Recipes pancake = new Recipes(
                    "https://res.cloudinary.com/dgabkajhe/image/upload/v1709337647/Screenshot_425_asbwjt.png",
                    "Buttermilk Pancakes",
                    "1 cup, 1 tsp, 1 tsp, 1, 1 1/8 cup, 2 tbsp, null",
                    "flour, salt, baking soda, large egg, buttermilk, butter(melted), Syrup(Optional)",
                    "Yummy Buttermilk pancakes",
                    "1. Preheat and grease skillet 2. Mix flour, salt, baking soda. Then add egg, buttermilk, and butter. Batter should look thick, spongy, and puffy.  3. Drop 1/3 cup of batter, spread lightly, cook until lightly browned on each side, 1-2 minutes per side.",
                    "30",
                    "210",
                    0,
                    false,
                    2
            );

            Recipes soup = new Recipes(
                    "https://res.cloudinary.com/dgabkajhe/image/upload/v1709337647/Screenshot_425_asbwjt.png",
                    "Vegetable Soup",
                    "2 cups, 1 cup, 1 cup, 1/2 cup, 1/2 cup, 2 tbsp, 1 tsp, 2, 1",
                    "vegetable broth, carrots(diced), celery(diced), onion(diced), green beans(chopped), tomato(diced), garlic(minced), salt, pepper",
                    "Healthy and hearty vegetable soup",
                    "1. In a large pot, sauté garlic, onion, carrots, and celery. 2. Add broth and bring to a boil. 3. Add remaining vegetables and simmer until tender. Season with salt and pepper.",
                    "45",
                    "180",
                    0,
                    true,
                    3
            );

            Recipes sandwich = new Recipes(
                    "https://res.cloudinary.com/dgabkajhe/image/upload/v1709337647/Screenshot_425_asbwjt.png",
                    "Turkey Avocado Sandwich",
                    "2 slices, 2 slices, 1/2 avocado, 2 slices, 1/4 cup, 2 tbsp",
                    "whole wheat bread, turkey breast, avocado(sliced), tomato, lettuce, mayonnaise",
                    "A delicious and healthy turkey sandwich",
                    "1. Toast bread slices. 2. Spread mayonnaise on one slice of bread. 3. Layer turkey, avocado, tomato, and lettuce. 4. Top with the second slice of bread.",
                    "10",
                    "320",
                    2,
                    true,
                    4
            );

            Recipes curry = new Recipes(
                    "https://res.cloudinary.com/dgabkajhe/image/upload/v1709337647/Screenshot_425_asbwjt.png",
                    "Chicken Curry",
                    "1 lb, 1 cup, 1, 1/2 cup, 2 tbsp, 1 tsp, 1 tsp, 1/2 cup",
                    "chicken breast(cubed), coconut milk, onion(chopped), tomato(pureed), curry paste, garlic(minced), ginger(minced), water",
                    "A flavorful chicken curry dish",
                    "1. Sauté garlic, onion, and ginger. 2. Add chicken and cook until browned. 3. Stir in curry paste and cook for 1 minute. 4. Add coconut milk, tomato puree, and water. 5. Simmer until chicken is cooked through.",
                    "50",
                    "380",
                    0,
                    false,
                    5
            );

            Recipes smoothie = new Recipes(
                    "https://res.cloudinary.com/dgabkajhe/image/upload/v1709337647/Screenshot_425_asbwjt.png",
                    "Berry Blast Smoothie",
                    "1 cup, 1/2 cup, 1/2 cup, 1/4 cup, 1/4 cup",
                    "mixed berries(frozen), banana(sliced), spinach, yogurt, almond milk",
                    "Refreshing and nutritious berry smoothie",
                    "1. Combine all ingredients in a blender. 2. Blend until smooth and creamy. 3. Add more almond milk if needed for desired consistency.",
                    "5",
                    "150",
                    3,
                    true,
                    6
            );

            Recipes stirFry = new Recipes(
                    "https://res.cloudinary.com/dgabkajhe/image/upload/v1709337647/Screenshot_425_asbwjt.png",
                    "Vegetable Stir Fry",
                    "2 cups, 1 cup, 1 cup, 1 cup, 1/4 cup, 2 tbsp, 1 tbsp, 2",
                    "mixed vegetables, tofu(cubed), bell pepper(sliced), onion(sliced), soy sauce, vegetable oil, garlic(minced), ginger(minced)",
                    "A quick and easy vegetable stir-fry",
                    "1. Heat oil in a pan and add garlic and ginger. 2. Add tofu and cook until browned. 3. Add vegetables and stir-fry until tender. 4. Stir in soy sauce and cook for another minute.",
                    "20",
                    "250",
                    1,
                    true,
                    7
            );

            Recipes omelette = new Recipes(
                    "https://res.cloudinary.com/dgabkajhe/image/upload/v1709337647/Screenshot_425_asbwjt.png",
                    "Spinach Mushroom Omelette",
                    "3, 2 tbsp, 1/4 cup, 1/4 cup, 1/4 cup, 1/4 cup, 1/4 cup",
                    "eggs, butter, spinach(chopped), mushrooms(sliced), onion(diced), bell pepper(diced), cheese(grated)",
                    "A savory and filling omelette",
                    "1. Melt butter in a skillet over medium heat. 2. Add vegetables and cook until softened. 3. In a bowl, beat eggs and pour over vegetables. 4. Cook until eggs are set. 5. Sprinkle cheese on top and fold in half.",
                    "15",
                    "280",
                    0,
                    true,
                    6
            );

            Recipes tacos = new Recipes(
                    "https://res.cloudinary.com/dgabkajhe/image/upload/v1709337647/Screenshot_425_asbwjt.png",
                    "Beef Tacos",
                    "8, 1 lb, 1 cup, 1 cup, 1/4 cup, 1 tbsp, 1 tsp, 1 tsp",
                    "taco shells, ground beef, lettuce(shredded), tomato(diced), cheese(grated), taco seasoning, salt, pepper",
                    "Classic beef tacos",
                    "1. Brown ground beef in a skillet over medium heat. 2. Drain excess fat and add taco seasoning, salt, and pepper. 3. Heat taco shells according to package instructions. 4. Fill taco shells with beef mixture, lettuce, tomato, and cheese.",
                    "25",
                    "350",
                    0,
                    true,
                    4
            );

            Recipes pizza = new Recipes(
                    "https://res.cloudinary.com/dgabkajhe/image/upload/v1709337647/Screenshot_425_asbwjt.png",
                    "Margherita Pizza",
                    "1 lb, 2 cups, 1/4 cup, 2 tbsp, 1 tbsp, 1 tsp, 1/2 tsp",
                    "pizza dough, mozzarella cheese(sliced), tomato sauce, olive oil, garlic(minced), basil leaves, salt",
                    "Classic Italian margherita pizza",
                    "1. Preheat oven to 450°F. 2. Roll out pizza dough and place on a baking sheet. 3. Spread tomato sauce over dough. 4. Arrange mozzarella slices on top. 5. Drizzle with olive oil and sprinkle minced garlic and salt. 6. Bake for 12-15 minutes, until crust is golden and cheese is bubbly. 7. Garnish with fresh basil leaves before serving.",
                    "30",
                    "300",
                    0,
                    false,
                    3
            );

            Recipes sushi = new Recipes(
                    "https://res.cloudinary.com/dgabkajhe/image/upload/v1709337647/Screenshot_425_asbwjt.png",
                    "California Roll",
                    "1 cup, 1 cup, 2 sheets, 1/2 cup, 1/4 cup, 1/4 cup, 2 tbsp, 1 tbsp, 1 tbsp, 1 tsp",
                    "sushi rice, water, nori sheets, imitation crab meat, cucumber(julienned), avocado(sliced), rice vinegar, sugar, salt, sesame seeds",
                    "Classic California roll sushi",
                    "1. Rinse rice until water runs clear, then cook with water in a rice cooker. 2. In a small saucepan, combine rice vinegar, sugar, and salt. Heat until sugar dissolves. 3. Spread rice evenly over nori sheet, leaving a 1-inch border. 4. Arrange crab, cucumber, and avocado along the center. 5. Roll tightly, seal with water, and sprinkle with sesame seeds. 6. Cut into bite-sized pieces and serve with soy sauce and wasabi.",
                    "45",
                    "350",
                    0,
                    true,
                    2
            );

            Recipes lasagna = new Recipes(
                    "https://res.cloudinary.com/dgabkajhe/image/upload/v1709337647/Screenshot_425_asbwjt.png",
                    "Classic Lasagna",
                    "1 lb, 12 ounces, 2 cups, 1/2 cup, 1/4 cup, 2 cloves, 1/2 tsp, 1/4 tsp, 1/4 tsp, 2 cups",
                    "ground beef, lasagna noodles, ricotta cheese, grated parmesan cheese, mozzarella cheese(shredded), garlic(minced), salt, black pepper, dried oregano, marinara sauce",
                    "A hearty and comforting classic lasagna",
                    "1. Preheat oven to 375°F. 2. Brown ground beef in a skillet over medium heat. Drain excess fat. 3. Stir in garlic, salt, pepper, and oregano. 4. Spread a layer of marinara sauce in a baking dish. 5. Layer noodles, beef mixture, ricotta, and mozzarella. Repeat layers. 6. Cover with foil and bake for 25 minutes. Remove foil and bake for an additional 25 minutes until bubbly and golden.",
                    "90",
                    "450",
                    0,
                    false,
                    5
            );

            Recipes burger = new Recipes(
                    "https://res.cloudinary.com/dgabkajhe/image/upload/v1709337647/Screenshot_425_asbwjt.png",
                    "Classic Beef Burger",
                    "1 lb, 4 slices, 4, 4, 1/4 cup, 1/4 cup, 2 tbsp, 1 tbsp, 1 tsp, to taste",
                    "ground beef, burger buns, lettuce leaves, tomato slices, onion slices, pickles, ketchup, mustard, salt, pepper",
                    "A juicy and delicious classic beef burger",
                    "1. Divide ground beef into 4 equal portions and shape into patties. 2. Season patties with salt and pepper. 3. Grill patties over medium-high heat for 4-5 minutes per side, or until desired doneness. 4. Toast burger buns on the grill. 5. Assemble burgers with lettuce, tomato, onion, pickles, ketchup, and mustard.",
                    "20",
                    "400",
                    0,
                    true,
                    2
            );

            Recipes chickenWrap = new Recipes(
                    "https://res.cloudinary.com/dgabkajhe/image/upload/v1709337647/Screenshot_425_asbwjt.png",
                    "Grilled Chicken Wrap",
                    "1 lb, 4, 4, 1/4 cup, 1/4 cup, 2 tbsp, 2 tbsp, 1 tbsp, 1 tsp, to taste",
                    "chicken breast, whole wheat wraps, lettuce leaves, tomato slices, shredded cheese, ranch dressing, barbecue sauce, olive oil, salt, pepper",
                    "A flavorful grilled chicken wrap",
                    "1. Season chicken breast with olive oil, salt, and pepper. 2. Grill chicken over medium-high heat for 6-8 minutes per side, or until cooked through. 3. Slice chicken into strips. 4. Warm wraps in a skillet or microwave. 5. Layer wraps with lettuce, tomato, chicken strips, cheese, ranch dressing, and barbecue sauce. 6. Roll up tightly and serve.",
                    "25",
                    "380",
                    0,
                    false,
                    7
            );

            Recipes bakedSalmon = new Recipes(
                    "https://res.cloudinary.com/dgabkajhe/image/upload/v1709337647/Screenshot_425_asbwjt.png",
                    "Baked Salmon",
                    "4 fillets, 1/4 cup, 2 tbsp, 1 tbsp, 1 tsp, 1 tsp, to taste",
                    "salmon fillets, soy sauce, honey, olive oil, garlic(minced), lemon juice, salt, pepper",
                    "Healthy and flavorful baked salmon",
                    "1. Preheat oven to 375°F. 2. In a small bowl, whisk together soy sauce, honey, olive oil, garlic, lemon juice, salt, and pepper. 3. Place salmon fillets in a baking dish and pour sauce over them. 4. Bake for 12-15 minutes, or until salmon flakes easily with a fork.",
                    "20",
                    "300",
                    0,
                    true,
                    4
            );

            repository.saveAll(
                    List.of(pasta, salad, pancake, soup, sandwich, curry, smoothie, stirFry, omelette, tacos, pizza, sushi, lasagna, burger, chickenWrap, bakedSalmon)
            );


        };
    }
}
