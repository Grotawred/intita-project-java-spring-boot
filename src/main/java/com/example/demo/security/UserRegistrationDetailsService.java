package com.example.demo.security;

import static com.example.demo.constants.TextConstants.TEXT_USER_NOT_FOUND;

import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRegistrationDetailsService implements UserDetailsService {
  private final UserRepository userRepository;
  private final UserMapper mapper;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    return mapper.listOfUserToListOfUserDto(userRepository
                    .findByEmail(email)).stream().findAny()
            .map(UserRegistrationDetails::new)
            .orElseThrow(() -> new UsernameNotFoundException(TEXT_USER_NOT_FOUND));
  }
}
