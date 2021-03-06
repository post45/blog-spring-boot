package com.arthur.blog.service;

import com.arthur.blog.domain.LoginForm;
import com.arthur.blog.domain.User;
import com.arthur.blog.exceptions.UserNameAlreadyExistsResponse;
import com.arthur.blog.exceptions.UsernameAlreadyExistsException;
import com.arthur.blog.repo.UserRepo;
import com.arthur.blog.utils.SpecialChars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    private final String loginErrorMessage = "Username or password incorrect";

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepo userRepo;

    //has to be unique user
    public void save(User user) {
        try {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

            user.setEmail(user.getEmail());
            user.setPassword(user.getPassword());
            user.setConfirmPassword("");// will not show confirm pass
//        validatePassword(user.getPassword());
//            if (userRepo.getByEmail(user.getEmail()) != null)
//                return;
            userRepo.save(user);
        } catch (Exception e) {
        throw new UsernameAlreadyExistsException("User '"+user.getEmail()+"'already exists");
        }
    }


    public User login(String email, String password) {
        User user = userRepo.getByEmail(email);
        if (user == null) {
            throw new IllegalArgumentException(loginErrorMessage);
        }
        if (password.equals(user.getPassword())) {
            return user;
        } else throw new IllegalArgumentException(loginErrorMessage);
    }

    public User login(LoginForm form) {
        return login(form.getEmail(), form.getPassword());
    }

    public User getUser(int id) {
        return userRepo.getById((long) id);
    }

    //get all users
    public List<User> getAllByIdNotNull() {
        return userRepo.getAllByIdNotNull();
    }

    //delete user by id
    public void deleteUserByID(int id) {
        userRepo.deleteById((long) id);
    }

    public User getByEmail(String email){
        return userRepo.getByEmail(email);
    }

    //    private  void validatePassword(String password){
//        boolean contains = false;
//        for(String specialChar:  SpecialChars.getSpecialCharsStatic()) {
//           if(password.contains(specialChar))
//             contains = true;
//        }
//        if (!contains)
//            throw new IllegalArgumentException("Password should contain special character");
//    }


}

