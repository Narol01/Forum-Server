package ait.cohort34.forumservice.service;

import ait.cohort34.forumservice.dao.ForumRepository;
import ait.cohort34.forumservice.dto.DataDto;
import ait.cohort34.forumservice.dto.PostAddDto;
import ait.cohort34.forumservice.dto.PostDto;
import ait.cohort34.forumservice.model.Post;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ForumServiceImpl implements ForumService {
@Autowired
    private final ForumRepository forumRepository;
    private final ModelMapper modelMapper;

    @Override
    public PostDto addPost(String user, PostAddDto postAddDto) {
    Post post = new Post(postAddDto.getTitle(), postAddDto.getContent(), user,postAddDto.getTags());
    forumRepository.save(post);
        return modelMapper.map(post,PostDto.class);
    }

    @Override
    public PostDto findPostById(String postId) {
       Post post =forumRepository.findById(postId);
        return modelMapper.map(post,PostDto.class);
    }

    @Override
    public PostDto addLike(String postId) {
        Post post = forumRepository.findById(postId);
        post.addLikes();
        forumRepository.save(post);
        return modelMapper.map(post,PostDto.class);
    }

    @Override
    public Iterable<PostDto> findPostsByAuthor(String user) {
        return forumRepository.findPostsByAuthor(user)
                .map(s->modelMapper.map(s, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDto addComments(String postId, String user, String massage) {
        Post post = forumRepository.findById(postId);
        post.setComments(user, massage);
        forumRepository.save(post);
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public PostDto deletePost(String postId) {
        Post post = forumRepository.deleteById(postId);
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public Iterable<PostDto> findPostByTags(Set<String> tags) {
        return forumRepository.findByTagsIn(tags)
                .map(s->modelMapper.map(s, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<PostDto> findPostByPeriod(DataDto dataDto) {
        return forumRepository.findPostsByDateRange(dataDto.getFrom(),dataDto.getTo())
                .map(s->modelMapper.map(s,PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDto updatePost(String postId, PostAddDto postAddDto) {
        Post existingPost=forumRepository.findById(postId);
        existingPost.setTitle(postAddDto.getTitle());
        existingPost.setTags(postAddDto.getTags());
        existingPost.setContent(postAddDto.getContent());
        Post updatedPost = forumRepository.save(existingPost);
        return modelMapper.map(updatedPost,PostDto.class);
    }
}
