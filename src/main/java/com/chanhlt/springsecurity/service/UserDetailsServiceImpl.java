package com.chanhlt.springsecurity.service;

import java.util.Arrays;
import java.util.List;

import com.chanhlt.springsecurity.model.User;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private FirebaseApp firebaseApp;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String token) throws UsernameNotFoundException {
        try {
            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(firebaseApp);
            FirebaseToken decodedToken = firebaseAuth.verifyIdTokenAsync(token).get();
            User user = userService.getUserByEmail(decodedToken.getEmail());
            if (user == null)
                throw new UsernameNotFoundException("User not found!");

            List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
            return new org.springframework.security.core.userdetails.User(user.getEmail(), passwordEncoder.encode(user.getEmail()),
                    authorities);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new UsernameNotFoundException("User not found!");
        }
    }
}