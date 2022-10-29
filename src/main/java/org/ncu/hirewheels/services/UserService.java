package org.ncu.hirewheels.services;

import java.util.Optional;

import org.ncu.hirewheels.entities.User;

public interface UserService {
    public User createUser(User user);
    public Optional<User> getUser(String email, String password) throws Exception;
}
