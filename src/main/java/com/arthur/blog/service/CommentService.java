package com.arthur.blog.service;

import com.arthur.blog.domain.BlogPost;
import com.arthur.blog.domain.Comment;
import com.arthur.blog.domain.User;
import com.arthur.blog.repo.BlogPostRepo;
import com.arthur.blog.repo.CommentRepo;
import com.arthur.blog.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private  UserService userService;

    @Autowired
    private BlogPostService  blogPostService;

    public void save(Comment comment, int userID, int blogPostID) {
        User user = userService.getUser(userID);
        BlogPost blogPost = blogPostService.getPostByID(blogPostID);
        comment.setUser(user);
        comment.setBlogPost(blogPost);
        commentRepo.save(comment);
    }

    public Comment getCommentByID(long commentId) {
        return commentRepo.getByBlogPostId(commentId);
    }

    public void deletePostByID(int id) {
        commentRepo.deleteById((long) id);
    }
}