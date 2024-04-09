package ait.cohort34.forumservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostAddDto {
    private String title;
    private String content;
    private Set<String> tags;
}
