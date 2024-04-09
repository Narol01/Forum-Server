package ait.cohort34.forumservice.dto;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommentsDto {
    private String user;
    private String message;
    private LocalDateTime dateCreated=LocalDateTime.now();
    private int likes;

    public CommentsDto(String user, String message) {
        this.user = user;
        this.message = message;
    }

    public void addLikes(){
        this.likes++;
    }
}
