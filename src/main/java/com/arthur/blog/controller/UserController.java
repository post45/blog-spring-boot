package com.arthur.blog.controller;

import com.arthur.blog.domain.LoginForm;
import com.arthur.blog.domain.User;
import com.arthur.blog.repo.UserRepo;
import com.arthur.blog.service.MapValidationErrorService;
import com.arthur.blog.service.UserService;
import com.arthur.blog.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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


    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@Valid @RequestBody User user, BindingResult result) {
        ////validate password's match
        userValidator.validate(user, result);

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null)
            return errorMap;

        userService.save(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }


    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody @Valid LoginForm loginForm) {
        User user = userService.login(loginForm);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
        return "You are successful logout";
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllByIdNotNull() {
        return new ResponseEntity<>(userService.getAllByIdNotNull(), HttpStatus.OK);
    }

    //http://localhost:8080/api/user/delete/?id=7
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestParam int id) {
        userService.deleteUserByID(id);
        System.out.println("Successful deleted");

    }

}















