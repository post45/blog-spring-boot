package com.arthur.blog.controller;

import com.arthur.blog.domain.LoginForm;
import com.arthur.blog.domain.User;
import com.arthur.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, path = "/register")
    public ResponseEntity<?> register(@RequestBody @Valid User user){
        userService.save(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public ResponseEntity<?>login(@RequestBody @Valid LoginForm loginForm){
        User user  = userService.login(loginForm);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }
}
