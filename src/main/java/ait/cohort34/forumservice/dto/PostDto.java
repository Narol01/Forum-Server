package ait.cohort34.forumservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class PostDto {
     @Id
     private String  id;
     private String title;
     private String content;
     private String author;
     private LocalDateTime dateCreated = LocalDateTime.now();
     private Set<String> tags;
     private int likes;
     private List<String> comments;
     public PostDto( String title, String content, String author, Set<String> tags, List<String> comments) {
          this.title = title;
          this.content = content;
          this.author = author;
          this.tags = tags;
          this.likes = 0;
          this.comments = comments;
          this.dateCreated=getDateCreated();
     }
}
