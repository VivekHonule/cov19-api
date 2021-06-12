package com.dashboard.cov19;

import com.dashboard.cov19.entity.CovidCase;
import com.dashboard.cov19.entity.User;
import com.dashboard.cov19.repository.CovidCaseRepository;
import com.dashboard.cov19.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.ZonedDateTime;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final CovidCaseRepository covidCaseRepository;

    @Autowired
    public DatabaseSeeder(UserRepository userRepository, CovidCaseRepository covidCaseRepository) {
        this.userRepository = userRepository;
        this.covidCaseRepository = covidCaseRepository;
    }

    @Override
    public void run(String... args) {
        User user1 = new User("Vivek", "Honule", "vivekhonule@gmail.com", "password");
        User user2 = new User("Neha", "Honule", "nehahonule@gmail.com", "pwd");
        userRepository.save(user1);
        userRepository.save(user2);

        long milliSeconds = ZonedDateTime.now().toInstant().toEpochMilli();
        CovidCase covidCase1 = new CovidCase("Patient1", "India", "Maharashtra", new Date(milliSeconds), "Active");
        CovidCase covidCase2 = new CovidCase("Patient2", "India", "Maharashtra", new Date(milliSeconds), "Recovered");
        CovidCase covidCase3 = new CovidCase("Patient3", "India", "Maharashtra", new Date(milliSeconds), "Recovered");
        CovidCase covidCase4 = new CovidCase("Patient4", "India", "Maharashtra", new Date(milliSeconds), "Deceased");


        CovidCase covidCase5 = new CovidCase("Patient5", "Australia", "Sydney", new Date(milliSeconds), "Active");
        CovidCase covidCase6 = new CovidCase("Patient6", "Australia", "Sydney", new Date(milliSeconds), "Recovered");
        CovidCase covidCase7 = new CovidCase("Patient7", "Australia", "Sydney", new Date(milliSeconds), "Deceased");
        CovidCase covidCase8 = new CovidCase("Patient8", "Australia", "Sydney", new Date(milliSeconds), "Deceased");

        covidCaseRepository.save(covidCase1);
        covidCaseRepository.save(covidCase2);
        covidCaseRepository.save(covidCase3);
        covidCaseRepository.save(covidCase4);

        covidCaseRepository.save(covidCase5);
        covidCaseRepository.save(covidCase6);
        covidCaseRepository.save(covidCase7);
        covidCaseRepository.save(covidCase8);
    }
}


