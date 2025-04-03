package com.engineeringDigest.journalApp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment in MySQL
    private Long id;

    @Column(length = 30)
    private String username;

    private int age;

    @Column(length = 30)
    private String city;

    @Column(length = 30)
    private String speciality;
}
