package com.engineeringDigest.journalApp.entity;

import lombok.Data;

@Data
public class JournalEntryRequest {

    private String content;
    private String title;
    private Long userId;  // Foreign key to the UserEntity

    // Getters and setters
    /* public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }*/
}
