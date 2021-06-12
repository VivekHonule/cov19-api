package com.dashboard.cov19.controller;

import com.dashboard.cov19.exception.RegistrationException;
import com.dashboard.cov19.model.UserViewModel;
import com.dashboard.cov19.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/registration")
@CrossOrigin
public class RegistrationController {

    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public void registerUser(@RequestBody UserViewModel viewModel) throws RegistrationException {
        registrationService.register(viewModel);
    }
}
