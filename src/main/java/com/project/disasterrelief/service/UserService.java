package com.project.disasterrelief.service;

import com.project.disasterrelief.model.User;

public interface UserService {
    User registerUser(User user);
    User findByUsernameOrEmail(String usernameOrEmail);
}