package com.example.todo.security.custom;

import com.example.todo.user.model.entity.UserEntity;
import com.example.todo.user.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity byUserId = userRepository.findByUserId(username);
        if (byUserId == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(byUserId);
    }
}
