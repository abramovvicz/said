package com.saidproject.saidproject.security;

import com.saidproject.saidproject.dao.user.User;
import com.saidproject.saidproject.repo.user.UserRepo;
import com.saidproject.saidproject.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("user with username: " + username + " not found");
        }
        return new CustomUserDetails(user );
    }
}
