package com.engineeringDigest.journalApp.controller;

import com.engineeringDigest.journalApp.entity.Comment;
import com.engineeringDigest.journalApp.entity.CommentDTO;
import com.engineeringDigest.journalApp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping
    public ResponseEntity<Comment> createNewComment(@RequestBody CommentDTO commentDTO) throws Exception {
        Comment comment = commentService.createNewComment(commentDTO);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    @GetMapping("/{entryId}")
    public ResponseEntity<List<Comment>> showCommentByEntryId(@PathVariable Long entryId){
        return new ResponseEntity<>(commentService.getAllCommentsByEntry(entryId),HttpStatus.OK);
    }
}
