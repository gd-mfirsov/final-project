package com.mfirsov.shop.service;

import com.mfirsov.shop.model.UserDetailsImpl;
import com.mfirsov.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(username)
                             .map(UserDetailsImpl::new)
                             .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }
}
