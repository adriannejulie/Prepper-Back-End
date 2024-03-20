package com.prepper.prepper.controller;
import com.prepper.prepper.service.UsersService;
import com.prepper.prepper.model.Users;
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

    @PostMapping("/addUser")
    public ResponseEntity<Users> addUser(@RequestBody Users user) {
        Users email = userService.getAccountByEmailAddress(user.getEmail());
        if (email == null) {
            Users newUser = userService.saveUser(user);
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
    @GetMapping("/login/{email}")
    public ResponseEntity<Users> getUserByEmail(@PathVariable String email, @RequestBody String password, @RequestBody Boolean isGoogle) {
        Users user = userService.getAccountByEmailAddress(email);
        if (isGoogle){
            if ( user != null ) {
                return ResponseEntity
                        .ok()
                        .body(user);
            }
        } else {
            if (Objects.equals(user.getPassword(), password)) {
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
    public ResponseEntity<Object> getUserData(@PathVariable String email){
            Users user = userService.getAccountByEmailAddress(email);
            if ( user == null) {
                HttpHeaders headers = new HttpHeaders();
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
}
