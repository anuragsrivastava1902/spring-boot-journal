package com.engineeringDigest.journalApp.repository;

import com.engineeringDigest.journalApp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    // You can define custom query methods here if necessary
}
