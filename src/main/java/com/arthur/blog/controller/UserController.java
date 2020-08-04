package com.arthur.blog.controller;

import com.arthur.blog.domain.LoginForm;
import com.arthur.blog.domain.User;
import com.arthur.blog.repo.UserRepo;
import com.arthur.blog.service.MapValidationErrorService;
import com.arthur.blog.service.UserService;
import com.arthur.blog.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping(path = "api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping( path = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@Valid @RequestBody User user, BindingResult result){
        ////validate password's match
        userValidator.validate(user,result);

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap !=null)
            return errorMap;

        userService.save(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }


    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ResponseEntity<?>login(@RequestBody @Valid LoginForm loginForm){
        User user  = userService.login(loginForm);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }


//    @RequestMapping(path = "/all", method = RequestMethod.GET)
//    public ResponseEntity<?>allUsers(@RequestParam int id){
//        return new ResponseEntity<>(userService.getUser(id),HttpStatus.OK);
//    }

    @RequestMapping(path = "logout", method = RequestMethod.POST)
    public ResponseEntity<?>logout(@RequestBody )
}
