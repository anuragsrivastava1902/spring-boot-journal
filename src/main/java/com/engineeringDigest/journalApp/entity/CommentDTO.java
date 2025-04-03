package com.engineeringDigest.journalApp.entity;

import lombok.Data;

@Data
public class CommentDTO {
    private String content;
    private Long userId;
    private Long entryId;
}
