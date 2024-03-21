package com.prepper.prepper.service;


import com.prepper.prepper.model.Users;
import com.prepper.prepper.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public Users saveUser(Users user) {
        return usersRepository.save(user);
    }
    public Users getUserById(String userID) {
        return usersRepository.findByUserID(Long.valueOf(userID));

    }
    public Users getAccountByEmailAddress(String email) {
        return usersRepository.findByEmail(email);
    }

    public Users deleteUserByEmail(String email) {
        Users userToDelete = usersRepository.findByEmail(email);
    
        if (userToDelete != null) {
            usersRepository.delete(userToDelete);
            return userToDelete; // Indicate successful deletion
        } else {
            return userToDelete; // Indicate user with given ID not found
        }
    }
    
    
}
