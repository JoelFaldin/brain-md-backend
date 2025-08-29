package com.example.brainmd.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    public User createUser(String email, String name, String picture) {
        User newUser = new User(name, email, picture);

        return this.userRepository.save(newUser);
    }

    public boolean searchUser(String email) {
        return this.userRepository.existsByEmail(email);
    }

    public User getUserData(String email) {
        return this.userRepository.getByEmail(email);
    }
}
