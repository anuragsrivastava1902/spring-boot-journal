package com.engineeringDigest.journalApp.repository;

import com.engineeringDigest.journalApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // You can define custom query methods here if necessary
}
