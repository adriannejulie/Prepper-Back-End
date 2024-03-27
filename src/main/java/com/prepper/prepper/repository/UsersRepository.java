package com.prepper.prepper.repository;

import com.prepper.prepper.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    
    /**
     * Retrieves a Users object using an email
     * @param email
     * @return Users Objects
     */
    Users findByEmail(String email);

    /**
     * Retrieves a Users object using a userID
     * @param userID
     * @return Users Objects
     */
    Users findByUserID(Long userID);

}
