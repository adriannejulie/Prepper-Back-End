package com.prepper.prepper.repository;

import com.prepper.prepper.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

}
