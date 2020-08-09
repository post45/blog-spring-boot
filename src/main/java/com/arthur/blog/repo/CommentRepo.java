package com.arthur.blog.repo;

import com.arthur.blog.domain.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends CrudRepository<Comment, Long> {

    Comment save(Comment comment);

    Comment getByBlogPostId(long commentId);

    //new find by post
    //List<Comment> getByBlogPost(BlogPost blogPost);

    List<Comment> findByBlogPost(Long blogPostId);

    //find All by User
    //List<Comment> getAllByUser(User user);
    List<Comment> getAllByUser(int userID);

//    List<Comment> findByBlogPost(BlogPost blogPost);





}
