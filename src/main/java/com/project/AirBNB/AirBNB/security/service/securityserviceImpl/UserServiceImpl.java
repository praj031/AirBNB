package com.project.AirBNB.AirBNB.security.service.securityserviceImpl;

import com.project.AirBNB.AirBNB.security.entity.User;
import com.project.AirBNB.AirBNB.exception.ResourceNotFoundException;
import com.project.AirBNB.AirBNB.security.repository.UserRepository;
import com.project.AirBNB.AirBNB.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: "+id));
    }

    @Override
    public @Nullable UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElse(null);
    }
}
