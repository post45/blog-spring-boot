package com.arthur.blog.service;

import com.arthur.blog.domain.Comment;
import com.arthur.blog.repo.BlogPostRepo;
import com.arthur.blog.repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private BlogPostRepo blogPostRepo;

    @Autowired
    private UserService userService;

    public void save(Comment comment) {
        commentRepo.save(comment);
    }

    public Comment getCommentByID(int id) {
        return commentRepo.getById((long) id);
    }

    public void deletePostByID(int id) {
        blogPostRepo.deleteById((long) id);
    }

}