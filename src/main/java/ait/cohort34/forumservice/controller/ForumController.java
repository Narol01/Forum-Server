package ait.cohort34.forumservice.controller;

import ait.cohort34.forumservice.dto.DataDto;
import ait.cohort34.forumservice.dto.PostAddDto;
import ait.cohort34.forumservice.dto.PostDto;
import ait.cohort34.forumservice.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class ForumController {
@Autowired
private ForumService forumService;

@PostMapping("/forum/post/{user}")
    public PostDto addPost(@PathVariable String user, @RequestBody PostAddDto postAddDto) {
        return forumService.addPost(user,postAddDto);
    }

@GetMapping("/forum/post/{postId}")
    public PostDto findPostById(@PathVariable String postId) {
        return forumService.findPostById(postId);
    }

@GetMapping("/forum/post/{postId}/like")
    public PostDto addLike(@PathVariable String postId) {
    return forumService.addLike(postId);
    }

@GetMapping("/forum/posts/author/{user}")
    public Iterable<PostDto> findPostsByAuthor(@PathVariable String user) {
        return forumService.findPostsByAuthor(user);
    }

@PutMapping("/forum/post/{postId}/comment/{user}")
    public PostDto addComments(@PathVariable String postId,@PathVariable String user,@RequestBody String massage) {
        return forumService.addComments(postId,user,massage);
    }

@DeleteMapping("/forum/post/{postId}")
    public PostDto deletePost(@PathVariable String postId) {
        return forumService.deletePost(postId);
    }

@PostMapping("/forum/posts/tags")
    public Iterable<PostDto> findPostByTags(@RequestBody Set<String> tags) {
        return forumService.findPostByTags(tags);
    }

@PostMapping("/forum/posts/period")
    public Iterable<PostDto> findPostByPeriods(@RequestBody DataDto dataDto) {
        return forumService.findPostByPeriod(dataDto);
    }
@PutMapping("/forum/post/{postId}")
    public PostDto updatePost(@PathVariable String postId,@RequestBody PostAddDto postAddDto) {
        return forumService.updatePost(postId,postAddDto);
    }
}
