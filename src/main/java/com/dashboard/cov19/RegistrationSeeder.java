package com.dashboard.cov19;

import com.dashboard.cov19.entity.User;
import com.dashboard.cov19.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RegistrationSeeder implements CommandLineRunner {

    private final UserRepository userRepository;

    @Autowired
    public RegistrationSeeder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        User user1 = new User("Vivek", "Honule", "vivekhonule@gmail.com", "password");
        User user2 = new User("Neha", "Honule", "nehahonule@gmail.com", "pwd");
        userRepository.save(user1);
        userRepository.save(user2);
    }
}
