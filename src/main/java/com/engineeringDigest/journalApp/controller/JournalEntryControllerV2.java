package com.engineeringDigest.journalApp.controller;

import com.engineeringDigest.journalApp.entity.JournalEntry;
import com.engineeringDigest.journalApp.entity.JournalEntryRequest;
import com.engineeringDigest.journalApp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll() {
        return journalEntryService.getAll();
    }

    @GetMapping("/{myid}")
    public ResponseEntity<JournalEntry> getById(@PathVariable Long myid) {
        Optional<JournalEntry> j = journalEntryService.getById(myid);
        if (j.isPresent()) {
            return new ResponseEntity<>(j.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /*@GetMapping("/")
    public ResponseEntity<String> throwError(){
        return ResponseEntity.badRequest().body("filll somethign you dfagot");
    }*/


    @PostMapping
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntryRequest request) {
        //  myEntry.setDate(LocalDateTime.now());
        try {
            JournalEntry myEntry = journalEntryService.createEntry(request);
            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //create an entry by form data
    @PostMapping("/createEntry")
    public ResponseEntity<JournalEntry> createEntry(
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("userId") Long userId) {
        try {
            // Process the form data
            JournalEntryRequest request = new JournalEntryRequest();
            request.setTitle(title);
            request.setContent(content);
            request.setUserId(userId);
            JournalEntry myEntry = journalEntryService.createEntry(request);
            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
        } catch (Exception e) {
            // Handle exceptions
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{myId}")
    public ResponseEntity<?> deleteEntryById(@PathVariable Long myId) {
        journalEntryService.deleteById(myId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*@PutMapping("/{myId}")
    public JournalEntry updateById(@PathVariable Long myId, @RequestBody JournalEntry newEntry){
        JournalEntry old = journalEntryService.getById(myId).orElse(null);
        if(old!=null){
            old.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().isEmpty() ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent()!=null && !newEntry.getContent().isEmpty() ? newEntry.getContent() : old.getContent());
        }
        journalEntryService.saveEntry(old);
        return old;
    }*/


}
