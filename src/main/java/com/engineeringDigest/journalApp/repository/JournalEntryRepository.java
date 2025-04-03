package com.engineeringDigest.journalApp.repository;

import com.engineeringDigest.journalApp.entity.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JournalEntryRepository extends JpaRepository<JournalEntry, Long> {
}