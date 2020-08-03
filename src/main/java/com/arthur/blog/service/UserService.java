package com.arthur.blog.service;

import com.arthur.blog.domain.LoginForm;
import com.arthur.blog.domain.User;
import com.arthur.blog.repo.UserRepo;
import com.arthur.blog.utils.SpecialChars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final String loginErrorMessage = "Username or password incorrect";

    @Autowired
    private UserRepo userRepo;


    public void save(User user){
        //has to be unique user
        user.setEmail(user.getEmail());

        validatePassword(user.getPassword());
        if (userRepo.getByEmail(user.getEmail())!=null)
            return;
        userRepo.save(user);
    }

    private  void validatePassword(String password){
        boolean contains = false;
        for(String specialChar:  SpecialChars.getSpecialCharsStatic()) {
           if(password.contains(specialChar))
             contains = true;
        }
        if (!contains)
            throw new IllegalArgumentException("Password should contain special character");
    }

    public User login(String email, String password){
       User user =  userRepo.getByEmail(email);
       if(user == null) {
           throw new IllegalArgumentException(loginErrorMessage);
       }
       if (password.equals(password)){
           return user;
       }
       else throw new IllegalArgumentException(loginErrorMessage);
    }

    public User login(LoginForm form){
        return  login(form.getEmail(), form.getPassword());
    }

    public User getUser(int id){
        return userRepo.getById((long)id);
    }


}

