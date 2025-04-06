package com.engineeringDigest.journalApp.service;

import com.engineeringDigest.journalApp.entity.User;
import com.engineeringDigest.journalApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Get all users
    public Page<User> getAllUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);  // Page is 0-based.
        return userRepository.findAll(pageable);
    }

    // Get a user by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Update an existing user
    public User updateUser(Long id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id); // Ensure the correct ID is set for the update
            return userRepository.save(user);
        } else {
            throw new RuntimeException("User not found with id " + id);
        }
    }

    // Delete a user
    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("User not found with id " + id);
        }
    }
}

