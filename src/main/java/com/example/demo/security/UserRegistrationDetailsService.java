//package com.example.demo.security;
//
//import com.example.demo.mapper.UserMapper;
//import com.example.demo.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import static com.example.demo.constants.TextConstants.USER_NOT_FOUND_MESSAGE;
//
//@Service
//@RequiredArgsConstructor
//public class UserRegistrationDetailsService implements UserDetailsService {
//    private final UserRepository userRepository;
//    private final UserMapper mapper;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return mapper.listOfUserToListOfUserDto(userRepository.findByLogin(username)).stream()
//                .findAny()
//                .map(UserRegistrationDetails::new)
//                .orElseThrow(() -> new UsernameNotFoundException(USER_NOT_FOUND_MESSAGE));
//    }
//}
