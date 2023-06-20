package com.example.demo.service;

import static com.example.demo.constants.TextConstants.ALREADY_EXIST_MESSAGE;
import static com.example.demo.constants.TextConstants.INVALID_VERIFICATION_TOKEN_LOG_MESSAGE;
import static com.example.demo.constants.TextConstants.TOKEN_ALREADY_EXPIRED_MESSAGE;
import static com.example.demo.constants.TextConstants.USER_WITH_EMAIL_MESSAGE;
import static com.example.demo.constants.TextConstants.VALID_MESSAGE;

import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.PersonalData;
import com.example.demo.model.User;
import com.example.demo.model.dto.PersonalDataDTO;
import com.example.demo.model.dto.UserDTO;
import com.example.demo.registration.RegistrationRequest;
import com.example.demo.registration.token.VerificationToken;
import com.example.demo.registration.token.VerificationTokenRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserDataRepository;
import com.example.demo.repository.UserRepository;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
  private final UserDataRepository userDataRepository;
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final VerificationTokenRepository tokenRepository;
  private final UserMapper mapper;
  private final RoleRepository roleRepository;

  @Override
  public List<UserDTO> getUsers() {
    return mapper.listOfUserToListOfUserDto(userRepository.findAll());
  }

  @Override
  public User registerUser(RegistrationRequest request) {
    List<UserDTO> user = this.findByEmail(request.email());
    if (!user.isEmpty()) {
      throw new UserAlreadyExistsException(
          USER_WITH_EMAIL_MESSAGE + request.email() + ALREADY_EXIST_MESSAGE);
    }
    var newUserData = PersonalData.builder().email(request.email()).build();
    userDataRepository.save(newUserData);
    var newUser =
        User.builder()
            .login(request.login())
            .password(passwordEncoder.encode(request.password()))
            .roles(roleRepository.findRoleByName(request.role()))
            .personalData(newUserData)
            .registrationDateTime(java.time.ZonedDateTime.now())
            .build();
    return userRepository.save(newUser);
  }

  @Override
  public List<UserDTO> findByEmail(String email) {
    PersonalDataDTO userData =
        mapper.personalDataToPersonalDataDto(userDataRepository.findByEmail(email));
    List<User> user;
    if (userData == null) {
      return new ArrayList<>();
    } else {
      user = userRepository.findByPersonalData(mapper.personalDataDtoToPersonalData(userData));
    }
    return mapper.listOfUserToListOfUserDto(user);
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
      return INVALID_VERIFICATION_TOKEN_LOG_MESSAGE;
    }
    UserDTO user = mapper.userToUserDto(token.getUser());
    Calendar calendar = Calendar.getInstance();
    if ((token.getExpirationTime().getTime() - calendar.getTime().getTime()) <= 0) {
      tokenRepository.delete(token);
      return TOKEN_ALREADY_EXPIRED_MESSAGE;
    }
    user.setVerified(true);
    userRepository.save(mapper.userDtoToUser(user));
    return VALID_MESSAGE;
  }
}
