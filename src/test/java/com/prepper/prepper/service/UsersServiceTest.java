package com.prepper.prepper.service;
import com.prepper.prepper.controller.UsersController;
import com.prepper.prepper.model.Users;
import com.prepper.prepper.repository.UsersRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
public class UsersServiceTest {

    @Mock
    private UsersRepository usersRepository;

    @InjectMocks
    private UsersService usersService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        Users user1 = new Users("test1@example.com", "firstName1", "lastName1", "password1", false);
        Users user2 = new Users("test2@example.com", "firstName2","lastName2", null, true);
        when(usersRepository.findByEmail("test1@example.com")).thenReturn(user1);
        when(usersRepository.findByUserID(user1.getUserID())).thenReturn(user1);
    }

    @Test
    public void saveUserTest() {
        Users newUser = new Users("test@gmail.com", "firstNameTest", "lastNameTest", "password", false);
        when(usersRepository.save(newUser)).thenReturn(newUser);
        Users savedUser = usersService.saveUser(newUser);
        assertNotNull(savedUser);
    }
    @Test
    public void getUserByIdTest(){
        Users expectedUser = usersRepository.findByEmail("test1@gmail.com");
        String actualUserID = expectedUser.getEmail();

        //UserID is not available

        assertNotNull(expectedUser.getUserID());
       // assertNotNull(actualUserID);
        assertEquals(expectedUser.getUserID(), "test1@example.com");

        //when(usersRepository.findByUserID(expectedUser.getUserID())).thenReturn(expectedUser);
        //Users actualUser = usersService.getUserById(Long.toString(actualUserID));
    }


    
}


