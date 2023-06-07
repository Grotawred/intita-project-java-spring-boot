package com.example.demo.service;

import static com.example.demo.constants.TextConstants.*;

import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.model.dto.UserDTO;
import com.example.demo.registration.RegistrationRequest;
import com.example.demo.registration.token.VerificationToken;
import com.example.demo.registration.token.VerificationTokenRepository;
import com.example.demo.repository.UserRepository;
import java.util.Calendar;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final VerificationTokenRepository tokenRepository;
  private final UserMapper mapper;

  @Override
  public List<UserDTO> getUsers() {
    return mapper.listOfUserToListOfUserDto(userRepository.findAll());
  }

  @Override
  public User registerUser(RegistrationRequest request) {
    List<UserDTO> user = this.findByEmail(request.email());
    if (user.isEmpty()) {
      throw new UserAlreadyExistsException(
          TEXT_USER_WITH_EMAIL + request.email() + TEXT_ALREADY_EXIST);
    }
    var newUser =
        UserDTO.builder()
            .firstName(request.firstName())
            .lastName(request.lastName())
            .email(request.email())
            .password(passwordEncoder.encode(request.password()))
            .role(request.role())
            .build();
    return userRepository.save(mapper.userDtoToUser(newUser));
  }

  @Override
  public List<UserDTO> findByEmail(String email) {
    return mapper.listOfUserToListOfUserDto(userRepository.findByEmail(email));
  }

  @Override
  public void saveUserVerificationToken(UserDTO theUser, String token) {
    var verificationToken = new VerificationToken(token, mapper.userDtoToUser(theUser));
    tokenRepository.save(verificationToken);
  }

  @Override
  public String validateToken(String theToken) {
    VerificationToken token = tokenRepository.findByToken(theToken);
    if (token == null) {
      return TEXT_ABOUT_INVALID_VERIFICATION_TOKEN;
    }
    UserDTO user = mapper.userToUserDto(token.getUser());
    Calendar calendar = Calendar.getInstance();
    if ((token.getExpirationTime().getTime() - calendar.getTime().getTime()) <= 0) {
      tokenRepository.delete(token);
      return TEXT_TOKEN_ALREADY_EXPIRED;
    }
    user.setEnabled(true);
    userRepository.save(mapper.userDtoToUser(user));
    return TEXT_VALID;
  }
}
