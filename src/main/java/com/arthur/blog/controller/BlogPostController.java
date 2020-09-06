package com.arthur.blog.controller;

import com.arthur.blog.domain.BlogPost;
import com.arthur.blog.domain.User;
import com.arthur.blog.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/post")
public class BlogPostController {
    //CRUD
    // C -create - POST
    // R - read - GET -- illegal
    // U - update - POST/ PATCH
    // D - delete - DELETE

    @Autowired
    private BlogPostService blogPostService;

    @RequestMapping (path ="/create-post", method = RequestMethod.POST)
     public ResponseEntity<BlogPost> createPost(@RequestBody @Valid BlogPost blogPost ){
        blogPostService.save(blogPost);
        return new ResponseEntity<BlogPost> (blogPost, HttpStatus.OK);
    }

    //api/posts/get?blogPostId=10
    @RequestMapping (value = "/get-post/{blogPostId}", method = RequestMethod.GET)
    public ResponseEntity<BlogPost> getPost(@PathVariable  int  blogPostId) {
      BlogPost blogPost = blogPostService.getPostByID(blogPostId);
      return new ResponseEntity<BlogPost>(blogPost, HttpStatus.OK);
    }
    //api/posts/delete/10
    @RequestMapping (value = "/delete-post", method = RequestMethod.DELETE)
    public void delete(@RequestParam int id) {
        blogPostService.deletePostByID(id);
    }
    // get all blogPost for USER
    @RequestMapping( path = "/user-posts/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> userPosts(@PathVariable int id) {
        return new ResponseEntity<>(blogPostService.getBlogPostList(id), HttpStatus.OK);
    }

}

