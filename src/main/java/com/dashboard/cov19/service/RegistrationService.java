package com.dashboard.cov19.service;

import com.dashboard.cov19.model.UserViewModel;
import com.dashboard.cov19.exception.RegistrationException;

public interface RegistrationService {

    void register(UserViewModel viewModel) throws RegistrationException;
}
