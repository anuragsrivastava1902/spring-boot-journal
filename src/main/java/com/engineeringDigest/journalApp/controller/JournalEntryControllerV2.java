package com.engineeringDigest.journalApp.controller;

import com.engineeringDigest.journalApp.entity.JournalEntry;
import com.engineeringDigest.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll(){
        return journalEntryService.getAll();
    }

    @GetMapping("/{myid}")
    public JournalEntry getById(@PathVariable ObjectId myid){
       return journalEntryService.getByID(myid).orElse(null);
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return true;
    }


}
