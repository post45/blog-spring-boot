package com.arthur.blog.controller;

import com.arthur.blog.domain.Comment;
import com.arthur.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;


    @RequestMapping(path = "/comment/{userID}/{blogPostID}", method = RequestMethod.POST)
    public ResponseEntity createComment(@Valid Comment comment, @PathVariable int userID, @PathVariable int blogPostID){
        commentService.save(comment, userID, blogPostID);
        return new ResponseEntity(comment,HttpStatus.OK);
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


    //new maybe wring all commetnts for post

    @RequestMapping(path="/comment/{userID}/{blogPostID}", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCommentsForPost(@PathVariable long blogPostID, @PathVariable long userID) {
        Comment comment = commentService.getCommentByID(blogPostID);
        return new ResponseEntity<Comment>(comment,HttpStatus.OK);
    }
    //new all

//        @GetMapping("/by-post/{postId}")
//    public ResponseEntity<List<CommentsDto>> getAllCommentsForPost(@PathVariable Long postId) {
//        return ResponseEntity.status(OK)
//                .body(commentService.getAllCommentsForPost(postId));
//    }
//
//    @GetMapping("/by-user/{userName}")
//    public ResponseEntity<List<CommentsDto>> getAllCommentsForUser(@PathVariable String userName){
//        return ResponseEntity.status(OK)
//                .body(commentService.getAllCommentsForUser(userName));
//    }

//    @GetMapping("/{id}")
//	public ResponseEntity<Comment> getComment(@PathVariable(name = "postId") Long postId,
//			@PathVariable(name = "id") Long id) {
//		Comment comment = commentService.getComment(postId, id);
//
//		return new ResponseEntity<Comment>(comment, HttpStatus.OK);
//	}

//     @GetMapping("/posts/{postId}/comments")
//    public Page<Comment> getAllCommentsByPostId(@PathVariable (value = "postId") Long postId,
//                                                Pageable pageable) {
//        return commentRepository.findByPostId(postId, pageable);
//    }





}







