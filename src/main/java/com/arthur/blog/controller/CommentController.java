package com.arthur.blog.controller;

import com.arthur.blog.domain.Comment;
import com.arthur.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping(path = "api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;


    @RequestMapping(path = "/comment/{userID}/{blogPostID}", method = RequestMethod.POST)
    public ResponseEntity createComment(@Valid Comment comment, @PathVariable int userID, @PathVariable int blogPostID,String email, Principal principal) {
        commentService.save(comment, userID, blogPostID, email);
        return new ResponseEntity(comment, HttpStatus.OK);
    }


    @RequestMapping(path = "/comment", method = RequestMethod.GET)
    public ResponseEntity<?> getComment(@RequestParam int commentId) {
        Comment comment = commentService.getCommentByID(commentId);
        return new ResponseEntity<Comment>(comment, HttpStatus.OK);
    }

    @RequestMapping(path = "/comment", method = RequestMethod.DELETE)
    public void delete(@RequestParam int id) {
        commentService.deletePostByID(id);
    }


    //new maybe wring all commetnts for post

    @RequestMapping(path = "/comment/{userID}/{blogPostID}", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCommentsForPost(@PathVariable long blogPostID, @PathVariable long userID) {
        Comment comment = commentService.getCommentByID(blogPostID);
        return new ResponseEntity<Comment>(comment, HttpStatus.OK);
    }
    //new. find All by User

    @RequestMapping(path = "/comment/{userId}", method = RequestMethod.GET)
    public ResponseEntity<?> getAllbyUser(@PathVariable long userID) {
        Comment comment = commentService.getCommentByID(userID);
        return new ResponseEntity<Comment>(comment, HttpStatus.OK);
    }


}







