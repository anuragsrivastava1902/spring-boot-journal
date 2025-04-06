package com.engineeringDigest.journalApp.service;

import com.engineeringDigest.journalApp.entity.Comment;
import com.engineeringDigest.journalApp.entity.CommentDTO;
import com.engineeringDigest.journalApp.entity.JournalEntry;
import com.engineeringDigest.journalApp.entity.User;
import com.engineeringDigest.journalApp.repository.CommentRepository;
import com.engineeringDigest.journalApp.repository.JournalEntryRepository;
import com.engineeringDigest.journalApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    JournalEntryRepository journalEntryRepository;

    public Comment createNewComment(CommentDTO commentDTO) throws Exception{
        User user = userRepository.findById(commentDTO.getUserId()).orElseThrow(()-> new RuntimeException("no user found"));
        JournalEntry journalEntry = journalEntryRepository.findById(commentDTO.getEntryId()).orElseThrow(() -> new RuntimeException("no entries found"));
        Comment comment = new Comment();
        comment.setContent(commentDTO.getContent());
        comment.setUser(user);
        comment.setJournalEntry(journalEntry);
        return commentRepository.save(comment);
    }

    public List<Comment> getAllCommentsByEntry(Long entryId) {
        return commentRepository.findCommentsByEntryId(entryId);
    }
}
