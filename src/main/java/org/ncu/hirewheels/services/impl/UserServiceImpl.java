package org.ncu.hirewheels.services.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.ncu.hirewheels.entities.User;
import org.ncu.hirewheels.repository.UserRepository;
import org.ncu.hirewheels.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public User createUser(User user) {
        try {
            User currUser = userRepository.save(user);
            return currUser;
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    @Transactional
    public Optional<User> getUser(String email, String password) throws Exception {
        try {
            Optional<User> user = userRepository.getUserByEmail(email);
            if (user.isPresent()) {
                User user2 = user.get();
                if (user2.getPassword().equals(password)) {
                    return user;
                } else {
                    throw new Exception("Email/Password is incorrect");
                }
            } else {
                throw new Exception("User not found");
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
