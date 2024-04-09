package ait.cohort34.forumservice.dao;

import ait.cohort34.forumservice.dto.DataDto;
import ait.cohort34.forumservice.dto.PostDto;
import ait.cohort34.forumservice.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Stream;

public interface ForumRepository extends MongoRepository<Post,Integer> {
Post findById(String postId);
Stream<Post> findPostsByAuthor(String user);
Post deleteById(String postId);
    @Query("{ 'tags' : { $in: ?0 } }")
Stream<Post> findByTagsIn(Set<String> tags);
    @Query("{ 'dateCreated' : { $gte: ?0, $lte: ?1 } }")
Stream<Post> findPostsByDateRange(LocalDate dateFrom, LocalDate dateTo);
}
