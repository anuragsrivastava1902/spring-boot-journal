package com.engineeringDigest.journalApp.service;


import com.engineeringDigest.journalApp.entity.JournalEntry;
import com.engineeringDigest.journalApp.entity.JournalEntryRequest;
import com.engineeringDigest.journalApp.entity.User;
import com.engineeringDigest.journalApp.repository.JournalEntryRepository;
import com.engineeringDigest.journalApp.repository.UserRepository;
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

    @Autowired
    private UserRepository userRepository;

    public JournalEntry createEntry(JournalEntryRequest journalEntryRequest) {
        User user = userRepository.findById(journalEntryRequest.getUserId()).orElseThrow(() -> new RuntimeException("user not found"));
        JournalEntry journalEntry = new JournalEntry();
        journalEntry.setContent(journalEntryRequest.getContent());
        journalEntry.setTitle(journalEntryRequest.getTitle());
        journalEntry.setUser(user);
        return journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> getById(Long myid) {
      return journalEntryRepository.findById(myid);
    }

    public void deleteById(Long id) {
            journalEntryRepository.deleteById(id);
    }

}
