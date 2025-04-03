package com.engineeringDigest.journalApp.service;

import com.engineeringDigest.journalApp.entity.UserEntity;
import com.engineeringDigest.journalApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Get all users
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    // Get a user by ID
    public Optional<UserEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Create a new user
    public UserEntity createUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    // Update an existing user
    public UserEntity updateUser(Long id, UserEntity userEntity) {
        if (userRepository.existsById(id)) {
            userEntity.setId(id); // Ensure the correct ID is set for the update
            return userRepository.save(userEntity);
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

