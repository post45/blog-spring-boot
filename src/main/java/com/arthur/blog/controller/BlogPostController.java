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
@RequestMapping(path = "api/posts")
public class BlogPostController {
    //CRUD
    // C -create - POST
    // R - read - GET -- illegal
    // U - update - POST/ PATCH
    // D - delete - DELETE

    @Autowired
    private BlogPostService blogPostService;

    @RequestMapping (path ="/post", method = RequestMethod.POST)
     public ResponseEntity<BlogPost> createPost(@RequestBody @Valid BlogPost blogPost ){
        blogPostService.save(blogPost);
        return new ResponseEntity<BlogPost> (blogPost, HttpStatus.OK);
    }

    //api/posts/get?blogPostId=10
    @RequestMapping (value = "/post", method = RequestMethod.GET)
    public ResponseEntity<BlogPost> getPost(@RequestParam  int  blogPostId) {
      BlogPost blogPost = blogPostService.getPostByID(blogPostId);
      return new ResponseEntity<BlogPost>(blogPost, HttpStatus.OK);
    }
    //api/posts/delete/10
    @RequestMapping (value = "/post", method = RequestMethod.DELETE)
    public void delete(@RequestParam int id) {
        blogPostService.deletePostByID(id);
    }
    // get all blogPOst for USER
    @RequestMapping(method = RequestMethod.GET, path = "/user-posts")
    public ResponseEntity<?> userPosts(@RequestParam int id) {
        return new ResponseEntity<>(blogPostService.getBlogPostList(id), HttpStatus.OK);
    }
}
