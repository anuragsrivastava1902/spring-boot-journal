package com.engineeringDigest.journalApp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class JournalEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;
}
