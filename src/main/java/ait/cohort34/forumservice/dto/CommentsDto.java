package ait.cohort34.forumservice.dto;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentsDto {
    private String user;
    private String message;
    private LocalDateTime dateCreated=LocalDateTime.now();
    private int likes;
}
