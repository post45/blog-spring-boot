package com.arthur.blog.repo;

import com.arthur.blog.domain.Comment;
import com.arthur.blog.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends CrudRepository<Comment, Long> {

    Comment save(Comment comment);

    Comment getByBlogPostId(long commentId);

    List<Comment> getAllByCreatedByAndOrderOrderByCreatedDate(User user);


}
