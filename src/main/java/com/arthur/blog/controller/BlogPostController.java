package com.arthur.blog.controller;

import com.arthur.blog.domain.BlogPost;
import com.arthur.blog.domain.User;
import com.arthur.blog.service.BlogPostService;
import com.arthur.blog.service.MapValidationErrorService;
import com.arthur.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

//locqlhost8080/api/post
@RestController
@RequestMapping(path = "api/post")
@CrossOrigin
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/create-post", method = RequestMethod.POST)
    public ResponseEntity<?> createPost(@RequestBody @Valid BlogPost blogPost, BindingResult result, Principal principal) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null) return errorMap;

        blogPostService.save(blogPost, principal.getName());
        return new ResponseEntity<BlogPost>(blogPost, HttpStatus.CREATED);
    }

    //api/posts/get?blogPostId=10
    @RequestMapping(value = "/get-post/{blogPostId}", method = RequestMethod.GET)
    public ResponseEntity<BlogPost> getPost(@PathVariable int blogPostId, Principal principal) {
        BlogPost blogPost = blogPostService.getPostByID(blogPostId, principal.getName());
        return new ResponseEntity<BlogPost>(blogPost, HttpStatus.OK);
    }

    //api/posts/delete/10
    @RequestMapping(value = "/delete-post", method = RequestMethod.DELETE)
    public void delete(@RequestParam int id) {
        blogPostService.deletePostByID(id);
    }

    // get all blogPost for USER
    @RequestMapping(path = "/user-posts", method = RequestMethod.GET)
    public ResponseEntity<?> userPosts(Principal principal) {
        User user = userService.getByEmail(principal.getName());
        return new ResponseEntity<>(blogPostService.getBlogPostList(user), HttpStatus.OK);
    }

}

