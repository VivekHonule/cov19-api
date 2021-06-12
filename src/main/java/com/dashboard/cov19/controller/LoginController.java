package com.dashboard.cov19.controller;

import com.dashboard.cov19.exception.LoginException;
import com.dashboard.cov19.model.UserViewModel;
import com.dashboard.cov19.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public UserViewModel authenticate(@RequestBody UserViewModel viewModel) throws LoginException {
        return loginService.authenticate(viewModel);
    }
}
