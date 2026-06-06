package com.waterplatform.service;

import com.waterplatform.model.User;
import com.waterplatform.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        String springRole = switch (user.getRole()) {
            case system_admin, franchise_admin -> "ROLE_ADMIN";
            case instructor -> "ROLE_INSTRUCTOR";
            case judge -> "ROLE_JUDGE";
            case volunteer -> "ROLE_VOLUNTEER";
            case participant -> "ROLE_USER";
        };

        return new org.springframework.security.core.userdetails.User(
            user.getUsername(),
            user.getPassword(),
            user.getStatus().name().equals("active"),
            true, true, true,
            List.of(new SimpleGrantedAuthority(springRole))
        );
    }
}
