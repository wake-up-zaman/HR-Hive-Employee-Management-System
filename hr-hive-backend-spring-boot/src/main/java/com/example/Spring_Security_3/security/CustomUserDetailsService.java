package com.example.Spring_Security_3.security;

import com.example.Spring_Security_3.entity.UserInfo;
//import com.example.Spring_Security_3.entity.UserDetailsInfo;
import com.example.Spring_Security_3.exception.ResourceNotFoundException;
import com.example.Spring_Security_3.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserInfoRepository userInfoRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo user = this.userInfoRepository.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException("User", "email" , username));
        return user;
    }
}
