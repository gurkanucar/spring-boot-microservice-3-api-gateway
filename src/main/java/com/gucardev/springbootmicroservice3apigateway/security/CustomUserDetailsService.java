package com.gucardev.springbootmicroservice3apigateway.security;

import com.gucardev.springbootmicroservice3apigateway.service.UserService;
import com.gucardev.springbootmicroservice3apigateway.model.User;
import com.gucardev.springbootmicroservice3apigateway.util.SecurityUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with given username: " + username));

        //authorities
        Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(user.getRole().name()));

        //UserDetails
        return UserPrincipal
                .builder()
                .user(user)
                .id(user.getId())
                .authorities(authorities)
                .password(user.getPassword())
                .username(username)
                .build();
    }


}
