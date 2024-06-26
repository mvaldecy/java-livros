package com.packt.carDatabase.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

import com.packt.carDatabase.model.User;
import com.packt.carDatabase.model.UserRepository;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService{
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);
        UserBuilder builder = null;
        if(user.isPresent()) {
            User currentUser = user.get();
            builder = org.springframework.security.core.userdetails.User.withUsername(userName);
            builder.password(currentUser.getPassword());
            builder.roles(currentUser.getRole());
        } else {
            throw new UsernameNotFoundException("User not found");
        }
        return builder.build();
    }
}
