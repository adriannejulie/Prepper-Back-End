package com.prepper.prepper.config;

import com.prepper.prepper.model.Users;
import com.prepper.prepper.repository.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UsersConfig {
    @Bean
    CommandLineRunner commandLineRunner2(
            UsersRepository repository) {
        return args -> {
            Users user1 = new Users(
                    "sarahqin@gmail.com",
                    "Sarah",
                    "Qin",
                    null,
                    true
            );

            Users user2 = new Users(
                    "juliaL@gmail.com",
                    "Julia",
                    "Lat",
                    "password123",
                    false
            );

            repository.saveAll(
                    List.of(user1, user2)
            );
        };
    }
}
