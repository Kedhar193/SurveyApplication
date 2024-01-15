 package com.example.project2.surveyapplication.services;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import com.example.project2.surveyapplication.daos.UserRepository;

import com.example.project2.surveyapplication.models.User;

@Service
public class UserService implements UserDetailsService {
	private final UserRepository userRepository;
    

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
		
    }



    public User saveUser(User user) {
        return userRepository.save(user);
    }



   
    


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return user;
    }


}
    // Additional methods if needed


