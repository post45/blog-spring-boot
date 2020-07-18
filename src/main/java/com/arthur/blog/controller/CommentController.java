package com.arthur.blog.controller;

import com.arthur.blog.domain.Comment;
import com.arthur.blog.service.CommentService;
import com.sun.javafx.beans.IDProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(path = "/comment", method = RequestMethod.POST)
    public String createComment(@Valid Comment comment){
        commentService.save(comment);
        return "redirect:/post/" + comment.getBlogPost().getId();
    }

    @RequestMapping(path = "/comment", method = RequestMethod.GET)
    public ResponseEntity<?>getComment(@RequestParam int commentId){
        Comment comment = commentService.getCommentByID(commentId);
        return new ResponseEntity<Comment>(comment,HttpStatus.OK);
    }

    @RequestMapping(path = "/comment", method = RequestMethod.DELETE)
    public void delete(@RequestParam int id){
        commentService.deletePostByID(id);
    }

//    @RequestMapping(path = "/user-comments", method = RequestMethod.GET)
//    public ResponseEntity<?>userComments(@RequestParam int id){
//        return new ResponseEntity<>(commentService)
//    }
}
