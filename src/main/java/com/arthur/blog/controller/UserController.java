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
    public ResponseEntity<?>login(@RequestBody @Valid LoginForm loginForm){
        User user  = userService.login(loginForm);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
        return "logout";
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<User>>getAllByIdNotNull(){
        return new ResponseEntity<>(userService.getAllByIdNotNull(),HttpStatus.OK);
    }
//http://localhost:8080/api/user/delete/?id=7
    @RequestMapping (value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestParam int id) {
        userService.deleteUserByID(id);
    }

}



//@RequestMapping(value = "/all", method = RequestMethod.GET)
//    public ResponseEntity<?> allUsers(@RequestParam int id) {
//        return new ResponseEntity<>(userService.getUserList(id),HttpStatus.OK);
//    }

//    @GetMapping
//    public ResponseEntity<List<Student>> findAll() {
//        return ResponseEntity.ok(StudentServiceImpl.findAll());
//    }














//    @RequestMapping(path = "/logout", method = RequestMethod.GET)
//    public ResponseEntity<?>logout(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest){
//        refreshTokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
//        return ResponseEntity.status(HttpStatus.OK).body("Refresh Token Deleted Successfully!!");
//    }




//    @RequestMapping("/login")
//    public String login(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout, Model model) {
//
//        if (error != null) {
//            model.addAttribute("error", "Wrong username or password!");
//        }
//        if (logout != null) {
//            model.addAttribute("msg", "You have successfully logged out!");
//        }
//        return "login";
//    }
//}