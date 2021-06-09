package com.dashboard.cov19.registration;

import com.dashboard.cov19.Status;
import com.dashboard.cov19.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/registration")
public class RegistrationController {

    private final RegistrationRepository registrationRepository;

    @Autowired
    public RegistrationController(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public Status registerUser(@RequestBody User user) {
        //ToDO: This object should be sent as json as response
        Status status;
        try {
            registrationRepository.save(user);
            status = new Status(StatusType.SUCCESS, "SUCCESS");
        } catch (Exception e) {
            status = new Status(StatusType.ERROR, "Something went wrong");

        }
        return status;
    }
}
