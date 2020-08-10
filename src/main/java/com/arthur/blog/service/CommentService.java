package com.arthur.blog.service;

import com.arthur.blog.domain.BlogPost;
import com.arthur.blog.domain.Comment;
import com.arthur.blog.domain.User;
import com.arthur.blog.repo.BlogPostRepo;
import com.arthur.blog.repo.CommentRepo;
import com.arthur.blog.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private BlogPostService blogPostService;

    @Autowired
    private BlogPostRepo blogPostRepo;

    @Autowired
    private UserRepo userRepo;

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


    //  getAllCommentsForPost
    public List<Comment> findByBlogPost(Long blogPostId) {
        blogPostRepo.findById(blogPostId);
        return commentRepo.findByBlogPost(blogPostId);
    }

    //1. getByBlogPost
//    public List<Comment> getByBlogPost(BlogPost blogPostId){
//    commentRepo.getByBlogPost(blogPostId);
//      return getByBlogPost(blogPostId);
//    }

    //2. getAllByUser
    public List<Comment> getAllByUser(int userID) {
        commentRepo.getAllByUser(userID);
        return commentRepo.getAllByUser(userID);
    }
}