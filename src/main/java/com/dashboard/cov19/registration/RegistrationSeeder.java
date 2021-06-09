package com.dashboard.cov19.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RegistrationSeeder implements CommandLineRunner {

    private final RegistrationRepository registrationRepository;

    @Autowired
    public RegistrationSeeder(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @Override
    public void run(String... args) {
        User user1 = new User("Vivek", "Honule", "vivekhonule@gmail.com", "password", "Maharashtra");
        User user2 = new User("Neha", "Honule", "nehahonule@gmail.com", "pwd", "Maharashtra");
        registrationRepository.save(user1);
        registrationRepository.save(user2);
    }
}
