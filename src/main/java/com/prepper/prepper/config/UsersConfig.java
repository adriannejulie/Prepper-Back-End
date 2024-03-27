package com.prepper.prepper.config;

import com.prepper.prepper.model.Users;
import com.prepper.prepper.repository.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * This configures the Users Table in database with sample data at startup
 *
 */

@Configuration
public class UsersConfig {
    @Bean
    CommandLineRunner commandLineRunner2(
            UsersRepository repository) {
        return args -> {
            Users user1 = new Users(
                    "sukihey@gmail.com",
                    "Sarah",
                    "Qin",
                    null,
                    true
            );
            Users user2 = new Users(
                    "julial@hotmail.com",
                    "Julia",
                    "Lat",
                    "password123",
                    false
            );

            Users user3 = new Users(
                    "nicholas@hotmail.com",
                    "Nick",
                    "Garcia",
                    "password",
                    false
            );

            Users user4 = new Users(
                    "bradenvivas@hotmail.com",
                    "Braden",
                    "Vivas",
                    "pass123456",
                    false
            );

            Users user5 = new Users(
                    "jordanT@hotmail.com",
                    "Tordan",
                    "T",
                    "pass123",
                    false
            );

            Users user6 = new Users(
                    "jordanV@hotmail.com",
                    "Vordan",
                    "V",
                    "123456",
                    false
            );

            Users user7 = new Users(
                    "coleT@hotmail.com",
                    "Cole",
                    "Thompson",
                    "123456789",
                    false
            );

            repository.saveAll(
                    List.of(user1, user2, user3, user4, user5, user6, user7)
            );
        };
    }
}
