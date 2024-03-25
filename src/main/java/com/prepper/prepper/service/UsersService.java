package com.prepper.prepper.service;


import com.prepper.prepper.model.Users;
import com.prepper.prepper.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    /**
     *  Saves user into database
     *
     * @param user The user information to be saved
     * @return Saved user
     */
    public Users saveUser(Users user) {
        return usersRepository.save(user);
    }

    /**
     *  Retrieves user information given userID
     *
     * @param userID The userID
     * @return Corresponding user if found
     */
    public Users getUserById(String userID) {
        return usersRepository.findByUserID(Long.valueOf(userID));
    }

    /**
     *  Retrieves user information given email
     *
     * @param email The email
     * @return Corresponding user if found
     */
    public Users getAccountByEmailAddress(String email) {
        return usersRepository.findByEmail(email);
    }

    /**
     *  Remove user given user email
     *
     * @param email The email of user to be removed
     * @return Referenced user
     */
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
