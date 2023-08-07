package com.example.demo.service;

import com.example.demo.exception.LocalDateException;
import com.example.demo.exception.SwearWordsException;
import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.entity.PersonalData;
import com.example.demo.entity.User;
import com.example.demo.entity.dto.PersonalDataDTO;
import com.example.demo.entity.dto.UserDTO;
import com.example.demo.request.RegistrationRequest;
import com.example.demo.entity.VerificationToken;
import com.example.demo.repository.VerificationTokenRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserDataRepository;
import com.example.demo.repository.UserRepository;
//import com.example.demo.validators.ValidatorSwearWords;
import com.example.demo.validators.ValidateContainSpecialSymbols;
import com.example.demo.validators.ValidatorDateOfBirth;
import com.uttesh.exude.exception.InvalidDataException;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.WordUtils;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;

import static com.example.demo.constants.TextConstants.*;

@Service
@RequiredArgsConstructor
public class UserService{
    private final UserDataRepository userDataRepository;
    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
    private final VerificationTokenRepository tokenRepository;
    private final UserMapper mapper;
    private final RoleRepository roleRepository;
    private final ValidatorDateOfBirth validatorDateOfBirth = new ValidatorDateOfBirth();
    private final ValidateContainSpecialSymbols validatorContainSpecialSymbols = new ValidateContainSpecialSymbols();


    public List<UserDTO> getUsers() {

        return mapper.listOfUserToListOfUserDto(userRepository.findAll());
    }


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
//                        .password(passwordEncoder.encode(request.password()))
                        .roles(roleRepository.findRoleByName(request.role()))
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

    @Override
    public LocalDate validateLocalDate(LocalDate localDate, LocalDate personalDate) {
        if(localDate == null) {
            return personalDate;
        } else{
            return localDate;
        }
    }

    @Override
    public String validateInfo(String info, String personalInfo) {
        if(info.isEmpty()) {
            return personalInfo;
        } else{
            return info;
        }
    }

    @Override
    public String validateSwearWords(String info) throws SwearWordsException, IOException, ParseException {
        ClassPathResource staticDataResource = new ClassPathResource("listOfSwearWords.json");
        String staticDataString = IOUtils.toString(staticDataResource.getInputStream(), StandardCharsets.UTF_8);
        Map<String, Object> listOfSwearWords = new JSONObject(staticDataString).toMap();
        List<Object> listOfSwearWords2 = (List<Object>) listOfSwearWords.get("swearWords");
        info = info.toLowerCase();
        for (Object i : listOfSwearWords2) {
            if (info.contains(i.toString())) {
                throw new SwearWordsException("Bad Words in Data");
            }
        }
        return WordUtils.capitalizeFully(info);
    }

    @Override
    public LocalDate validateDateOfBirth(LocalDate localDate) throws LocalDateException {
        return validatorDateOfBirth.execute(localDate);
    }

    @Override
    public String validateSpecialSymbols(String info) throws InvalidDataException {
        return validatorContainSpecialSymbols.execute(info);
    }
}
