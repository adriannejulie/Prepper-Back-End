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
import java.util.Optional;

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
        Users expectedUser = new Users("test@gmail.com", "firstNameTest", "lastNameTest", "password", false);
        expectedUser.setUserID(1L);
        when(usersRepository.findByUserID(1L)).thenReturn(expectedUser);

        Users actualUsers = usersService.getUserById(expectedUser.getUserID().toString());
        assertNotNull(expectedUser.getUserID());
        assertEquals(expectedUser, actualUsers);
        assertEquals(expectedUser.getUserID(), actualUsers.getUserID());
    }

    @Test
    public void getUserByEmailTest(){
        Users expectedUser = new Users("test1@example.com", "firstName1", "lastName1", "password1", false);
        when(usersRepository.findByEmail(expectedUser.getEmail())).thenReturn(expectedUser);

        Users actualUsers = usersService.getAccountByEmailAddress(expectedUser.getEmail());
        assertNotNull(actualUsers);
        assertEquals(expectedUser, actualUsers);
        assertEquals(expectedUser.getEmail(), actualUsers.getEmail());
    }

    @Test
    public void deleteUserByEmailTest() {
        Users user = usersRepository.findByEmail("test1@example.com");
        assertNotNull(user);
    
        usersService.deleteUserByEmail("test1@example.com");
        Users deletedUser = usersRepository.findByEmail("test1@example.com");
    
        assertNull(deletedUser); 
    }
        
}


