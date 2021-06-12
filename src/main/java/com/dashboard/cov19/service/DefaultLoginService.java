package com.dashboard.cov19.service;

import com.dashboard.cov19.entity.User;
import com.dashboard.cov19.exception.LoginException;
import com.dashboard.cov19.model.UserViewModel;
import com.dashboard.cov19.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultLoginService implements LoginService {

    private final UserRepository userRepository;

    @Autowired
    public DefaultLoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserViewModel authenticate(UserViewModel viewModel) throws LoginException {
        User byUsername = userRepository.findByUsername(viewModel.getUsername());

        if (!exists(byUsername)) {
            throw new LoginException("User is not registered");
        }

        if (!valid(byUsername, viewModel.getPassword())) {
            throw new LoginException("Password is incorrect");
        }

        return createViewModel(byUsername);
    }

    private UserViewModel createViewModel(User user) {
        UserViewModel viewModel = new UserViewModel();
        viewModel.setFirstName(user.getFirstName());
        viewModel.setLastName(user.getLastName());
        viewModel.setUsername(user.getUsername());
        return viewModel;
    }

    private boolean valid(User user, String password) {
        return user.getPassword().equals(password);
    }

    private boolean exists(User user) {
        return user != null;
    }
}
