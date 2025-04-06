package com.engineeringDigest.journalApp.repository;

import com.engineeringDigest.journalApp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("Select c from Comment c where c.journalEntry.id = :id")
    List<Comment> findCommentsByEntryId(@Param("id") Long id);
}
