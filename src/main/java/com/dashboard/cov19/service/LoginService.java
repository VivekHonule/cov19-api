package com.dashboard.cov19.service;

import com.dashboard.cov19.exception.LoginException;
import com.dashboard.cov19.model.UserViewModel;

public interface LoginService {
    UserViewModel authenticate(UserViewModel userViewModel) throws LoginException;
}
