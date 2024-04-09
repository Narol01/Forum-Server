package ait.cohort34.forumservice.model;

import ait.cohort34.forumservice.dto.CommentsDto;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@EqualsAndHashCode(of = "id")
@Getter
@NoArgsConstructor
public class Post {
    @Id
    private String id;
    @Setter
    private String title;
    @Setter
    private String content;
    private String author;
    private LocalDateTime dateCreated = LocalDateTime.now();
    @Setter
    private Set<String> tags;
    private int likes;
    @Setter
    private List<CommentsDto> comments;

    public Post( String title, String content, String author, Set<String> tags) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.tags = tags;
        this.likes = 0;
        this.dateCreated=getDateCreated();
    }
    public void setComments(String user,String massage) {
        if (this.comments == null) {
            this.comments = new ArrayList<>();
        }
        this.comments.add(new CommentsDto(user, massage));
    }

    public void addLikes(){
        this.likes++;
    }
}
