package com.example.demo.service;

import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.PersonalData;
import com.example.demo.model.TelephoneCode;
import com.example.demo.model.User;
import com.example.demo.model.dto.PersonalDataDTO;
import com.example.demo.model.dto.UserDTO;
import com.example.demo.registration.RegistrationRequest;
import com.example.demo.registration.token.VerificationToken;
import com.example.demo.registration.token.VerificationTokenRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.TelephoneCodeRepository;
import com.example.demo.repository.UserDataRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.validator.PersonalDataValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static com.example.demo.constants.TextConstants.*;

@Service
@RequiredArgsConstructor
public class UserService{
    private final UserDataRepository userDataRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final VerificationTokenRepository tokenRepository;
    private final UserMapper mapper;
    private final RoleRepository roleRepository;
    private final TelephoneCodeRepository telephoneCodeRepository;
    private final PersonalDataValidator personalDataValidator;


    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public List<PersonalData> getPersonalDatas() {
        return userDataRepository.findAll();
    }


    public User registerUser(RegistrationRequest request) {
        List<UserDTO> user = this.findByEmail(request.getEmail());
        if (!user.isEmpty()) {
            throw new UserAlreadyExistsException(
                    USER_WITH_EMAIL_MESSAGE + request.getEmail() + ALREADY_EXIST_MESSAGE);
        }
        var newUserData = PersonalData.builder().email(request.getEmail()).build();
        userDataRepository.save(newUserData);
        var newUser =
                User.builder()
                        .login(request.getLogin())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .roles(roleRepository.findRoleByName(request.getRole()))
                        .personalData(newUserData)
                        .registrationDateTime(java.time.ZonedDateTime.now())
                        .build();
        return userRepository.save(newUser);
    }


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


    public void saveUserVerificationToken(UserDTO theUser, String token) {
        var verificationToken = new VerificationToken(token, mapper.userDtoToUser(theUser));
        tokenRepository.save(verificationToken);
    }


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

    public void savePersonalData(PersonalData exitingPersonalData, PersonalData newPersonalData) {
        TelephoneCode newTelephoneCode = telephoneCodeRepository.findByCode(newPersonalData.getTelephone().getTelephoneCode().getCode());

        personalDataValidator.isValid(newPersonalData);

        exitingPersonalData.setFirstName(newPersonalData.getFirstName());
        exitingPersonalData.setLastName(newPersonalData.getLastName());
        exitingPersonalData.setDateOfBirth(newPersonalData.getDateOfBirth());
        exitingPersonalData.getTelephone().setTelephoneNumber(newPersonalData.getTelephone().getTelephoneNumber());
        exitingPersonalData.getTelephone().setTelephoneCode(newTelephoneCode);

        userDataRepository.save(exitingPersonalData);
    }

}
