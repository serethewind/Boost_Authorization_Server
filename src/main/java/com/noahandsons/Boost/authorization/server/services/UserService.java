//package com.noahandsons.Boost.authorization.server.services;
//
//import com.noahandsons.Boost.authorization.server.adapters.SecurityUser;
//import com.noahandsons.Boost.authorization.server.entities.User;
//import com.noahandsons.Boost.authorization.server.repositories.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class UserService implements UserDetailsService {
//
//    private final UserRepository userRepository;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//       User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
//       return new SecurityUser(user);
//    }
//}
