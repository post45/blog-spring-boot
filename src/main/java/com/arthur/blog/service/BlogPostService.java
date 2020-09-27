package com.arthur.blog.service;

import com.arthur.blog.domain.BlogPost;
import com.arthur.blog.domain.User;
import com.arthur.blog.repo.BlogPostRepo;
import com.arthur.blog.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepo blogPostRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    public void save( BlogPost blogPost, String email){
        blogPostRepo.save(blogPost);
    }

    public BlogPost getPostByID(int id, String email){
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
