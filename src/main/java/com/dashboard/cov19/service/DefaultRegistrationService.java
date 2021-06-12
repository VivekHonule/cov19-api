package com.dashboard.cov19.service;

import com.dashboard.cov19.entity.User;
import com.dashboard.cov19.exception.RegistrationException;
import com.dashboard.cov19.model.UserViewModel;
import com.dashboard.cov19.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultRegistrationService implements RegistrationService {

    private final UserRepository userRepository;

    @Autowired
    public DefaultRegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(UserViewModel viewModel) throws RegistrationException {
        User user = createUser(viewModel);
        try {
            userRepository.save(user);
        } catch (Exception e) {
            throw new RegistrationException("Username is already in use", e);
        }
    }

    private User createUser(UserViewModel viewModel) {
        User user = new User();
        user.setFirstName(viewModel.getFirstName());
        user.setLastName(viewModel.getLastName());
        user.setUsername(viewModel.getUsername());
        user.setPassword(viewModel.getPassword());
        return user;
    }
}
