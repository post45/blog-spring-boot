package com.arthur.blog.service;

import com.arthur.blog.domain.BlogPost;
import com.arthur.blog.domain.User;
import com.arthur.blog.repo.BlogPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepo blogPostRepo;

    @Autowired
    private UserService userService;

    public void save( BlogPost blogPost){
        blogPostRepo.save(blogPost);
    }

    public BlogPost getPostByID(int id){
        return blogPostRepo.getById((long) id);
    }
    public void deletePostByID(int id){
        blogPostRepo.deleteById((long)id);
    }
    //get all BlogPosts for USER
    public List<BlogPost> getBlogPostList(User user ){
       return blogPostRepo.getAllByCreatedBy(user.getId());
    }

    public List<BlogPost> getBlogPostList(int userID){
        User user = userService.getUser(userID);
        return getBlogPostList(user);
    }


}
