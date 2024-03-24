package com.prepper.prepper.controller;
import com.prepper.prepper.model.Recipes;
import com.prepper.prepper.model.SavedRecipes;
import com.prepper.prepper.service.MealPlansService;
import com.prepper.prepper.service.RecipesService;
import com.prepper.prepper.service.SavedRecipesService;
import com.prepper.prepper.service.UsersService;
import com.prepper.prepper.model.MealPlans;
import com.prepper.prepper.model.Users;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin("http://localhost:3000")
public class UsersController {
    @Autowired
    private UsersService userService;

    @Autowired
    private RecipesService recipesService;

    @Autowired
    private MealPlansService mpService;

    @Autowired
    private SavedRecipesService savedRecipesService;
    private Users user;

    @PostMapping("/addUser")
    public ResponseEntity<Users> addUser(@RequestBody Users user) {
        Users email = userService.getAccountByEmailAddress(user.getEmail());
        

        if (email != null) {
            if (email.isGoogle() == user.isGoogle() && (!email.getEmail().equals(email.getEmail()) || email.isGoogle())){
                if ( user != null ) {
                    this.user = email;
                    return ResponseEntity
                            .status(java.net.HttpURLConnection.HTTP_OK)
                            .header("User does not exist", "Email: " + String.valueOf(email.getEmail()) + "Google: " + String.valueOf(email.isGoogle()))
                            .body(email);
                }
            } else {    
                    return ResponseEntity
                        .status(java.net.HttpURLConnection.HTTP_CONFLICT)
                        .body(user);
            }
        }
        if (email ==  null){
            Users newUser = userService.saveUser(user);
            user = newUser;
            return ResponseEntity
                .status(java.net.HttpURLConnection.HTTP_OK)
                .body(newUser);
        } 
        return null;
    }

    @GetMapping("/login")
    public ResponseEntity<Users> getUserByEmail(@RequestParam String email, @RequestParam String password, @RequestParam Boolean isGoogle) {
        Users user = userService.getAccountByEmailAddress(email);
        if (user != null){
            if (user.isGoogle()){
                return ResponseEntity
                    .status(java.net.HttpURLConnection.HTTP_CONFLICT)
                    .header("User does not exist", "Email: " + String.valueOf(email))
                    .build();
            } else if (!user.isGoogle()){
                if (Objects.equals(user.getPassword(), password)) {
                    this.user = user;
                    return ResponseEntity
                            .ok()
                            .header("User exists", "Email: " + String.valueOf(email))
                            .body(user);
                            
                } else {
                    return ResponseEntity
                        .status(java.net.HttpURLConnection.HTTP_UNAUTHORIZED)
                        .header("Password does not match", "Email: " + String.valueOf(email))
                        .build();
                }
            }
        }
        
        return ResponseEntity
        .status(java.net.HttpURLConnection.HTTP_NOT_FOUND)
        .header("User does not exist", "Email: " + String.valueOf(email))
        .build();
    }
        
    @GetMapping("/userData/{email}")
    public ResponseEntity<Object> getUserWithEmail(@PathVariable String email){
            Users user = userService.getAccountByEmailAddress(email);
            if ( user == null) {
                HttpHeaders headers = new HttpHeaders();
                this.user = user;
                return ResponseEntity
                        .noContent()
                        .header("User does not exist", "Email: " + String.valueOf(email))
                        .build();
            } else {
                return ResponseEntity
                        .ok()
                        .body(user);
            }
        }

    @GetMapping("/userData")
    public ResponseEntity<Object> getUserData(){
            if ( this.user == null) {
                HttpHeaders headers = new HttpHeaders();
                return ResponseEntity
                        .noContent()
                        .header("User has not been assigned not exist")
                        .build();
            } else {
                return ResponseEntity
                        .ok()
                        .body(this.user);
            }
        }

    @GetMapping("/getUser/{userID}")
    public ResponseEntity<Users> getUserByID(@PathVariable String userID){
        Users user = userService.getUserById(userID);
        if ( user == null) {
            HttpHeaders headers = new HttpHeaders();
            return ResponseEntity
                    .noContent()
                    .header("User has not been assigned not exist")
                    .build();
        } else {
            return ResponseEntity
                    .ok()
                    .body(user);
        }
    }
    
    @DeleteMapping("/deleteUser")
    public ResponseEntity<Users> DeleteUser(@RequestBody int userID) {
        Users email = userService.getAccountByEmailAddress(user.getEmail());
        
        if (email == null) {
            Users newUser = userService.saveUser(user);
            user = newUser;
            return ResponseEntity
                    .ok()
                    .body(newUser);
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Email address already exists", "Email Address: " + email.getEmail());
            return ResponseEntity
                    .badRequest()
                    .headers(headers)
                    .build();
        }
    }

    @DeleteMapping("/users/{email}")
    public ResponseEntity<String> deleteUser(@PathVariable("email") String email) {

        Users userToDelete =  userService.deleteUserByEmail(email);
        Integer userID = userToDelete.getUserID().intValue();

        List<Recipes> recipesToDelete = recipesService.getRecipesByUser(userID);
        List<MealPlans> mealPlansToDelete = mpService.getMealPlansByUser(userID);
        List<SavedRecipes> savedRecipesToDelete = savedRecipesService.getSavedRecipesByUser(userID);

        for (Recipes recipes : recipesToDelete) {
            recipesService.removeRecipe(recipes.getRecipeID());
        }

        for (MealPlans mealPlans : mealPlansToDelete) {
            mpService.deleteMealPlan(mealPlans.getMealPlanID());
        }

        for (SavedRecipes savedRecipe : savedRecipesToDelete) {
            savedRecipesService.removeSavedRecipe(savedRecipe.getUserID(), savedRecipe.getRecipeID());
        }

        if (userToDelete != null){
            return ResponseEntity
                    .status(java.net.HttpURLConnection.HTTP_OK)
                                    .body(userToDelete.toString());
            
        } else {
        return ResponseEntity
                .status(java.net.HttpURLConnection.HTTP_GONE)
                .body(email);
        }

    }
}
