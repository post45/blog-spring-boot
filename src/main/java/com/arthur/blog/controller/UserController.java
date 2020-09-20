package com.arthur.blog.controller;

import com.arthur.blog.domain.LoginForm;
import com.arthur.blog.domain.User;
import com.arthur.blog.payload.JWTLoginSuccessResponse;
import com.arthur.blog.repo.UserRepo;
import com.arthur.blog.security.JwtTokenProvider;
import com.arthur.blog.service.MapValidationErrorService;
import com.arthur.blog.service.UserService;
import com.arthur.blog.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.arthur.blog.security.SecurityConst.TOKEN_PREFIX;

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

    @Autowired
    private JwtTokenProvider tokenProvider;
    @Autowired
    private AuthenticationManager authenticationManager;


    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@Valid @RequestBody User user, BindingResult result) {
        userValidator.validate(user, result);

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null)
            return errorMap;

        userService.save(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }


    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody @Valid LoginForm loginForm, BindingResult result) {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
    if(errorMap != null) return errorMap;

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginForm.getEmail(),
                        loginForm.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = TOKEN_PREFIX + tokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JWTLoginSuccessResponse(true, jwt));

       // User user = userService.login(loginForm);
        //return new ResponseEntity<User>(user, HttpStatus.OK);
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















