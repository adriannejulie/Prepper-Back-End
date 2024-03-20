package com.prepper.prepper.controller;
import com.prepper.prepper.service.UsersService;
import com.prepper.prepper.model.Users;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Objects;

@RestController
@CrossOrigin("http://localhost:3000")
public class UsersController {
    @Autowired
    private UsersService userService;
    private Users user;

    @PostMapping("/addUser")
    public ResponseEntity<Users> addUser(@RequestBody Users user) {
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
    @GetMapping("/login")
    public ResponseEntity<Users> getUserByEmail(@RequestParam String email, @RequestParam String password, @RequestParam Boolean isGoogle) {
        Users user = userService.getAccountByEmailAddress(email);
        if (isGoogle){
            if ( user != null ) {
                this.user = user;
                return ResponseEntity
                        .ok()
                        .body(user);
            }
        } else {
            if (Objects.equals(user.getPassword(), password)) {
                this.user = user;
                return ResponseEntity
                        .ok()
                        .body(user);
            } else {
                HttpHeaders headers = new HttpHeaders();
                return ResponseEntity
                        .badRequest()
                        .header("User does not exist", "Email: " + String.valueOf(email))
                        .build();
            }
        }
        return null;
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

}
