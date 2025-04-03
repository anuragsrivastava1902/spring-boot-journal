package com.engineeringDigest.journalApp.repository;

import com.engineeringDigest.journalApp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
