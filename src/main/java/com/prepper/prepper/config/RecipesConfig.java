package com.prepper.prepper.config;

import com.prepper.prepper.model.Recipes;
import com.prepper.prepper.repository.RecipesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * This configures the Recipe Table in database with sample data at startup
 *
 */

@Configuration
public class RecipesConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            RecipesRepository repository) {
        return args -> {
            Recipes pasta = new Recipes(
                    "https://res.cloudinary.com/dgabkajhe/image/upload/v1711409102/Screenshot_686_acouik.png",
                    "Chicken Alfredo Pasta",
                    "6 ounce, 8 ounce, 6 tbsp, 1/2 cup, 1/2 tsp, 2",
                    "fettuccine pasta, cream cheese, butter, milk, garlic powder, chicken breast(cooked)",
                    "Delicious homemade chicken alfredo",
                    "1. Boil pasta, cook for 8-10 minutes \n2. While pasta is cooking, melt cream cheese and butter in skillet over low heat. Stir until smooth. Stir in milk, and season with garlic powder, salt and pepper.",
                    "40",
                    "645",
                    0,
                    true,
                    1
            );

            Recipes salad = new Recipes(
                    "https://res.cloudinary.com/dgabkajhe/image/upload/v1711409107/Screenshot_687_esmxun.png",
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
                    "https://res.cloudinary.com/dgabkajhe/image/upload/v1711410392/Screenshot_683_z9xhby.png",
                    "Buttermilk Pancakes",
                    "1 cup, 1 tsp, 1 tsp, 1, 1 1/8 cup, 2 tbsp, null",
                    "flour, salt, baking soda, large egg, buttermilk, butter(melted), Syrup(Optional)",
                    "Yummy Buttermilk pancakes",
                    "1. Preheat and grease skillet \n2. Mix flour, salt, baking soda. Then add egg, buttermilk, and butter. Batter should look thick, spongy, and puffy. \n3. Drop 1/3 cup of batter, spread lightly, cook until lightly browned on each side, 1-2 minutes per side.",
                    "30",
                    "210",
                    0,
                    true,
                    2
            );

            Recipes soup = new Recipes(
                    "https://res.cloudinary.com/dgabkajhe/image/upload/v1711409128/Screenshot_688_n8mcvn.png",
                    "Vegetable Soup",
                    "2 cups, 1 cup, 1 cup, 1/2 cup, 1/2 cup, 2 tbsp, 1 tsp, 2, 1",
                    "vegetable broth, carrots(diced), celery(diced), onion(diced), green beans(chopped), tomato(diced), garlic(minced), salt, pepper",
                    "Healthy and hearty vegetable soup",
                    "1. In a large pot, sauté garlic, onion, carrots, and celery.\n2. Add broth and bring to a boil.\n3. Add remaining vegetables and simmer until tender. Season with salt and pepper.",
                    "45",
                    "180",
                    0,
                    true,
                    3
            );

            Recipes sandwich = new Recipes(
                    "https://res.cloudinary.com/dgabkajhe/image/upload/v1711409117/Screenshot_689_wt6sl6.png",
                    "Turkey Avocado Sandwich",
                    "2 slices, 2 slices, 1/2 avocado, 2 slices, 1/4 cup, 2 tbsp",
                    "whole wheat bread, turkey breast, avocado(sliced), tomato, lettuce, mayonnaise",
                    "A delicious and healthy turkey sandwich",
                    "1. Toast bread slices. \n2. Spread mayonnaise on one slice of bread. \n3. Layer turkey, avocado, tomato, and lettuce. \n4. Top with the second slice of bread.",
                    "10",
                    "320",
                    2,
                    true,
                    4
            );

            Recipes curry = new Recipes(
                    "https://res.cloudinary.com/dgabkajhe/image/upload/v1711410210/Screenshot_697_ldg1i0.png",
                    "Chicken Curry",
                    "1 lb, 1 cup, 1, 1/2 cup, 2 tbsp, 1 tsp, 1 tsp, 1/2 cup",
                    "chicken breast(cubed), coconut milk, onion(chopped), tomato(pureed), curry paste, garlic(minced), ginger(minced), water",
                    "A flavorful chicken curry dish",
                    "1. Sauté garlic, onion, and ginger. \n2. Add chicken and cook until browned. \n3. Stir in curry paste and cook for 1 minute. \n4. Add coconut milk, tomato puree, and water. \n5. Simmer until chicken is cooked through.",
                    "50",
                    "380",
                    0,
                    true,
                    5
            );

            Recipes smoothie = new Recipes(
                    "https://res.cloudinary.com/dgabkajhe/image/upload/v1711409133/Screenshot_690_vdfhx2.png",
                    "Berry Blast Smoothie",
                    "1 cup, 1/2 cup, 1/2 cup, 1/4 cup, 1/4 cup",
                    "mixed berries(frozen), banana(sliced), spinach, yogurt, almond milk",
                    "Refreshing and nutritious berry smoothie",
                    "1. Combine all ingredients in a blender. \n2. Blend until smooth and creamy. \n3. Add more almond milk if needed for desired consistency.",
                    "5",
                    "150",
                    3,
                    true,
                    6
            );

            Recipes stirFry = new Recipes(
                    "https://res.cloudinary.com/dgabkajhe/image/upload/v1711409139/Screenshot_691_rdwtfv.png",
                    "Vegetable Stir Fry",
                    "2 cups, 1 cup, 1 cup, 1 cup, 1/4 cup, 2 tbsp, 1 tbsp, 2",
                    "mixed vegetables, tofu(cubed), bell pepper(sliced), onion(sliced), soy sauce, vegetable oil, garlic(minced), ginger(minced)",
                    "A quick and easy vegetable stir-fry",
                    "1. Heat oil in a pan and add garlic and ginger. \n2. Add tofu and cook until browned. \n3. Add vegetables and stir-fry until tender. \n4. Stir in soy sauce and cook for another minute.",
                    "20",
                    "250",
                    1,
                    true,
                    7
            );

            Recipes omelette = new Recipes(
                    "https://res.cloudinary.com/dgabkajhe/image/upload/v1711409144/Screenshot_692_mncxtm.png",
                    "Spinach Mushroom Omelette",
                    "3, 2 tbsp, 1/4 cup, 1/4 cup, 1/4 cup, 1/4 cup, 1/4 cup",
                    "eggs, butter, spinach(chopped), mushrooms(sliced), onion(diced), bell pepper(diced), cheese(grated)",
                    "A savory and filling omelette",
                    "1. Melt butter in a skillet over medium heat. \n2. Add vegetables and cook until softened. \n3. In a bowl, beat eggs and pour over vegetables. \n4. Cook until eggs are set. \n5. Sprinkle cheese on top and fold in half.",
                    "15",
                    "280",
                    0,
                    true,
                    6
            );

            Recipes tacos = new Recipes(
                    "https://res.cloudinary.com/dgabkajhe/image/upload/v1711409147/Screenshot_693_bjxvht.png",
                    "Beef Tacos",
                    "8, 1 lb, 1 cup, 1 cup, 1/4 cup, 1 tbsp, 1 tsp, 1 tsp",
                    "taco shells, ground beef, lettuce(shredded), tomato(diced), cheese(grated), taco seasoning, salt, pepper",
                    "Classic beef tacos",
                    "1. Brown ground beef in a skillet over medium heat. \n2. Drain excess fat and add taco seasoning, salt, and pepper. \n3. Heat taco shells according to package instructions. \n4. Fill taco shells with beef mixture, lettuce, tomato, and cheese.",
                    "25",
                    "350",
                    0,
                    true,
                    4
            );

            Recipes pizza = new Recipes(
                    "https://res.cloudinary.com/dgabkajhe/image/upload/v1711410223/Screenshot_698_exbsu3.png",
                    "Margherita Pizza",
                    "1 lb, 2 cups, 1/4 cup, 2 tbsp, 1 tbsp, 1 tsp, 1/2 tsp",
                    "pizza dough, mozzarella cheese(sliced), tomato sauce, olive oil, garlic(minced), basil leaves, salt",
                    "Classic Italian margherita pizza",
                    "1. Preheat oven to 450°F. \n2. Roll out pizza dough and place on a baking sheet. \n3. Spread tomato sauce over dough. \n4. Arrange mozzarella slices on top. \n5. Drizzle with olive oil and sprinkle minced garlic and salt. \n6. Bake for 12-15 minutes, until crust is golden and cheese is bubbly. \n7. Garnish with fresh basil leaves before serving.",
                    "30",
                    "300",
                    0,
                    true,
                    3
            );

            Recipes sushi = new Recipes(
                    "https://res.cloudinary.com/dgabkajhe/image/upload/v1711409737/Screenshot_694_tjsv1o.png",
                    "California Roll",
                    "1 cup, 1 cup, 2 sheets, 1/2 cup, 1/4 cup, 1/4 cup, 2 tbsp, 1 tbsp, 1 tbsp, 1 tsp",
                    "sushi rice, water, nori sheets, imitation crab meat, cucumber(julienned), avocado(sliced), rice vinegar, sugar, salt, sesame seeds",
                    "Classic California roll sushi",
                    "1. Rinse rice until water runs clear, then cook with water in a rice cooker. \n2. In a small saucepan, combine rice vinegar, sugar, and salt. Heat until sugar dissolves. \n3. Spread rice evenly over nori sheet, leaving a 1-inch border. \n4. Arrange crab, cucumber, and avocado along the center. \n5. Roll tightly, seal with water, and sprinkle with sesame seeds. \n6. Cut into bite-sized pieces and serve with soy sauce and wasabi.",
                    "45",
                    "350",
                    0,
                    true,
                    2
            );

            Recipes lasagna = new Recipes(
                    "https://res.cloudinary.com/dgabkajhe/image/upload/v1711410201/Screenshot_699_kx6575.png",
                    "Classic Lasagna",
                    "1 lb, 12 ounces, 2 cups, 1/2 cup, 1/4 cup, 2 cloves, 1/2 tsp, 1/4 tsp, 1/4 tsp, 2 cups",
                    "ground beef, lasagna noodles, ricotta cheese, grated parmesan cheese, mozzarella cheese(shredded), garlic(minced), salt, black pepper, dried oregano, marinara sauce",
                    "A hearty and comforting classic lasagna",
                    "1. Preheat oven to 375°F. \n2. Brown ground beef in a skillet over medium heat. Drain excess fat. \n3. Stir in garlic, salt, pepper, and oregano. \n4. Spread a layer of marinara sauce in a baking dish. \n5. Layer noodles, beef mixture, ricotta, and mozzarella. Repeat layers. \n6. Cover with foil and bake for 25 minutes. Remove foil and bake for an additional 25 minutes until bubbly and golden.",
                    "90",
                    "450",
                    0,
                    true,
                    5
            );

            Recipes burger = new Recipes(
                    "https://res.cloudinary.com/dgabkajhe/image/upload/v1711409157/Screenshot_695_jetla2.png",
                    "Classic Beef Burger",
                    "1 lb, 4 slices, 4, 4, 1/4 cup, 1/4 cup, 2 tbsp, 1 tbsp, 1 tsp, to taste",
                    "ground beef, burger buns, lettuce leaves, tomato slices, onion slices, pickles, ketchup, mustard, salt, pepper",
                    "A juicy and delicious classic beef burger",
                    "1. Divide ground beef into 4 equal portions and shape into patties. \n2. Season patties with salt and pepper. \n3. Grill patties over medium-high heat for 4-5 minutes per side, or until desired doneness. \n4. Toast burger buns on the grill. \n5. Assemble burgers with lettuce, tomato, onion, pickles, ketchup, and mustard.",
                    "20",
                    "400",
                    0,
                    true,
                    2
            );

            Recipes chickenWrap = new Recipes(
                    "https://res.cloudinary.com/dgabkajhe/image/upload/v1711410196/Screenshot_700_nw65r4.png",
                    "Grilled Chicken Wrap",
                    "1 lb, 4, 4, 1/4 cup, 1/4 cup, 2 tbsp, 2 tbsp, 1 tbsp, 1 tsp, to taste",
                    "chicken breast, whole wheat wraps, lettuce leaves, tomato slices, shredded cheese, ranch dressing, barbecue sauce, olive oil, salt, pepper",
                    "A flavorful grilled chicken wrap",
                    "1. Season chicken breast with olive oil, salt, and pepper. \n2. Grill chicken over medium-high heat for 6-8 minutes per side, or until cooked through. \n3. Slice chicken into strips. \n4. Warm wraps in a skillet or microwave. \n5. Layer wraps with lettuce, tomato, chicken strips, cheese, ranch dressing, and barbecue sauce. \n6. Roll up tightly and serve.",
                    "25",
                    "380",
                    0,
                    true,
                    7
            );

            Recipes bakedSalmon = new Recipes(
                    "https://res.cloudinary.com/dgabkajhe/image/upload/v1711409162/Screenshot_696_rysm0z.png",
                    "Baked Salmon",
                    "4 fillets, 1/4 cup, 2 tbsp, 1 tbsp, 1 tsp, 1 tsp, to taste",
                    "salmon fillets, soy sauce, honey, olive oil, garlic(minced), lemon juice, salt, pepper",
                    "Healthy and flavorful baked salmon",
                    "1. Preheat oven to 375°F. \n2. In a small bowl, whisk together soy sauce, honey, olive oil, garlic, lemon juice, salt, and pepper. \n3. Place salmon fillets in a baking dish and pour sauce over them. \n4. Bake for 12-15 minutes, or until salmon flakes easily with a fork.",
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
