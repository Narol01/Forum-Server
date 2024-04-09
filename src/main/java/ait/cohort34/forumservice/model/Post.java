package ait.cohort34.forumservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@EqualsAndHashCode(of = "id")
@Getter
@NoArgsConstructor
public class Post {
    @Id
     String id;
    @Setter
     String title;
    @Setter
     String content;
     String author;
     LocalDateTime dateCreated = LocalDateTime.now();
    @Setter
     Set<String> tags = new HashSet<>();
     int likes;
    @Setter
     List<Comment> comments = new ArrayList<>();

    public Post( String title, String content, String author, Set<String> tags) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.tags = tags;
    }
    public void setComments(String user,String massage) {
        if (this.comments == null) {
            this.comments = new ArrayList<>();
        }
        this.comments.add(new Comment(user, massage));
    }

    public void addLikes(){
        this.likes++;
    }
}
