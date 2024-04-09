package ait.cohort34.forumservice.service;

import ait.cohort34.forumservice.dto.DataDto;
import ait.cohort34.forumservice.dto.PostAddDto;
import ait.cohort34.forumservice.dto.PostDto;

import java.util.List;
import java.util.Set;

public interface ForumService {
    PostDto addPost(String user, PostAddDto postAddDto);
    PostDto findPostById(String postId);
    PostDto addLike(String postId);
    Iterable<PostDto> findPostsByAuthor(String user);
    PostDto addComments(String postId,String user,String massage);
    PostDto deletePost(String postId);
    Iterable<PostDto> findPostByTags(Set<String> tags);
    Iterable<PostDto> findPostByPeriod(DataDto dataDto);
    PostDto updatePost(String postId,PostAddDto postAddDto);
}
