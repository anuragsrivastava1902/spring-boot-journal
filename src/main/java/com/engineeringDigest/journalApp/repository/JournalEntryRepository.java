package com.engineeringDigest.journalApp.repository;

import com.engineeringDigest.journalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;


public interface JournalEntryRepository extends JpaRepository<JournalEntry, Long> {
}