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

        CovidCase covidCase5 = new CovidCase("Patient5", "Australia", "Victoria", new Date(milliSeconds), "Active");
        CovidCase covidCase6 = new CovidCase("Patient6", "Australia", "Victoria", new Date(milliSeconds), "Recovered");
        CovidCase covidCase7 = new CovidCase("Patient7", "Australia", "Queensland", new Date(milliSeconds), "Deceased");
        CovidCase covidCase8 = new CovidCase("Patient8", "Australia", "Queensland", new Date(milliSeconds), "Deceased");

        CovidCase covidCase9 = new CovidCase("Patient9", "India", "Andhra Pradesh", new Date(milliSeconds), "Active");
        CovidCase covidCase10 = new CovidCase("Patient10", "India", "Uttar Pradesh", new Date(milliSeconds), "Recovered");
        CovidCase covidCase11 = new CovidCase("Patient11", "India", "Uttar Pradesh", new Date(milliSeconds), "Recovered");
        CovidCase covidCase12 = new CovidCase("Patient12", "India", "Gujarat", new Date(milliSeconds), "Deceased");


        CovidCase covidCase13 = new CovidCase("Patient13", "India", "Tamil Nadu", new Date(milliSeconds), "Active");
        CovidCase covidCase14 = new CovidCase("Patient14", "India", "Telangana", new Date(milliSeconds), "Recovered");
        CovidCase covidCase15 = new CovidCase("Patient15", "India", "Telangana", new Date(milliSeconds), "Active");
        CovidCase covidCase16 = new CovidCase("Patient16", "India", "Punjab", new Date(milliSeconds), "Deceased");

        CovidCase covidCase17 = new CovidCase("Patient17", "India", "Hariyana", new Date(milliSeconds), "Active");
        CovidCase covidCase18 = new CovidCase("Patient18", "India", "Kerala", new Date(milliSeconds), "Recovered");
        CovidCase covidCase19 = new CovidCase("Patient19", "India", "Kerala", new Date(milliSeconds), "Active");
        CovidCase covidCase20 = new CovidCase("Patient20", "India", "Himachal Pradesh", new Date(milliSeconds), "Deceased");

        CovidCase covidCase21 = new CovidCase("Patient21", "USA", "Texas", new Date(milliSeconds), "Active");
        CovidCase covidCase22 = new CovidCase("Patient22", "USA", "California", new Date(milliSeconds), "Recovered");
        CovidCase covidCase23 = new CovidCase("Patient23", "USA", "Texas", new Date(milliSeconds), "Active");
        CovidCase covidCase24 = new CovidCase("Patient24", "USA", "California", new Date(milliSeconds), "Deceased");

        CovidCase covidCase25 = new CovidCase("Patient25", "Italy", "Trentino", new Date(milliSeconds), "Active");
        CovidCase covidCase26 = new CovidCase("Patient26", "Italy", "Province of Verona", new Date(milliSeconds), "Recovered");
        CovidCase covidCase27 = new CovidCase("Patient27", "France", "Corse", new Date(milliSeconds), "Active");
        CovidCase covidCase28 = new CovidCase("Patient28", "France", "Centre", new Date(milliSeconds), "Deceased");

        CovidCase covidCase29 = new CovidCase("Patient29", "Germany", "Hessen", new Date(milliSeconds), "Active");
        CovidCase covidCase30 = new CovidCase("Patient30", "Germany", "Hessen", new Date(milliSeconds), "Recovered");
        CovidCase covidCase31 = new CovidCase("Patient31", "UK", "Scotland", new Date(milliSeconds), "Active");
        CovidCase covidCase32 = new CovidCase("Patient32", "UK", "Wales", new Date(milliSeconds), "Deceased");

        CovidCase covidCase33 = new CovidCase("Patient33", "Mexico", "Chiapas", new Date(milliSeconds), "Active");
        CovidCase covidCase34 = new CovidCase("Patient34", "Japan", "Tohoku", new Date(milliSeconds), "Recovered");
        CovidCase covidCase35 = new CovidCase("Patient35", "China", "Wuhan", new Date(milliSeconds), "Active");
        CovidCase covidCase36 = new CovidCase("Patient36", "China", "Wuhan", new Date(milliSeconds), "Deceased");


        covidCaseRepository.save(covidCase1);
        covidCaseRepository.save(covidCase2);
        covidCaseRepository.save(covidCase3);
        covidCaseRepository.save(covidCase4);

        covidCaseRepository.save(covidCase5);
        covidCaseRepository.save(covidCase6);
        covidCaseRepository.save(covidCase7);
        covidCaseRepository.save(covidCase8);

        covidCaseRepository.save(covidCase9);
        covidCaseRepository.save(covidCase10);
        covidCaseRepository.save(covidCase11);
        covidCaseRepository.save(covidCase12);

        covidCaseRepository.save(covidCase13);
        covidCaseRepository.save(covidCase14);
        covidCaseRepository.save(covidCase15);
        covidCaseRepository.save(covidCase16);

        covidCaseRepository.save(covidCase17);
        covidCaseRepository.save(covidCase18);
        covidCaseRepository.save(covidCase19);
        covidCaseRepository.save(covidCase20);

        covidCaseRepository.save(covidCase21);
        covidCaseRepository.save(covidCase22);
        covidCaseRepository.save(covidCase23);
        covidCaseRepository.save(covidCase24);

        covidCaseRepository.save(covidCase25);
        covidCaseRepository.save(covidCase26);
        covidCaseRepository.save(covidCase27);
        covidCaseRepository.save(covidCase28);

        covidCaseRepository.save(covidCase29);
        covidCaseRepository.save(covidCase30);
        covidCaseRepository.save(covidCase31);
        covidCaseRepository.save(covidCase32);

        covidCaseRepository.save(covidCase33);
        covidCaseRepository.save(covidCase34);
        covidCaseRepository.save(covidCase35);
        covidCaseRepository.save(covidCase36);
    }
}


