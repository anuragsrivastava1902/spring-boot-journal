package com.engineeringDigest.journalApp.service;


import com.engineeringDigest.journalApp.entity.JournalEntry;
import com.engineeringDigest.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public void saveEntry(JournalEntry journalEntry) {
        if (journalEntry != null) {
            journalEntryRepository.save(journalEntry);
        }
    }

    public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll();
    }

    /*public Optional<JournalEntry> getById(ObjectId myid) {
      return journalEntryRepository.findById(myid);
    }

    public void deleteById(ObjectId id) {
            journalEntryRepository.deleteById(id);
    }*/


}
