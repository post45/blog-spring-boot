package com.arthur.blog.service;

import com.arthur.blog.domain.User;
import com.arthur.blog.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService  implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.getByEmail(email);
        if(user==null) new UsernameNotFoundException("User not found");
        return user;
    }


    @Transactional
    public User getUserById(Long id){
        User user = userRepo.getById(id);
        if(user==null) new UsernameNotFoundException("User not found");
        return user;

    }
}
