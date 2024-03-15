package com.prepper.prepper.controller;

import com.prepper.prepper.model.Users;
import com.prepper.prepper.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
public class UsersController {
    @Autowired
    private UsersService userService;

    @PostMapping("/addUser")
    public void addUser(@RequestBody Users user) {
        Users newUser = userService.saveUser(user);
    }
}
