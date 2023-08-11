package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.ResetToken;
import com.example.demo.model.User;
import com.example.demo.model.dto.UserDTO;
import com.example.demo.repository.ResetTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;

import static com.example.demo.constants.TextConstants.*;

@Service
@RequiredArgsConstructor
public class ResetTokenService {
    private final ResetTokenRepository resetTokenRepository;
    private final UserMapper mapper;

    public void createToken(String token, UserDTO userDTO){
        User user = mapper.userDtoToUser(userDTO);

        ResetToken resetToken = new ResetToken(token, user);
        resetTokenRepository.save(resetToken);
    }

    public String validateToken(String theToken){
        ResetToken token = resetTokenRepository.findByToken(theToken);
        if (token == null) {
            return INVALID_RESET_TOKEN_MESSAGE;
        }
        Calendar calendar = Calendar.getInstance();
        if ((token.getExpirationTime().getTime() - calendar.getTime().getTime()) <= 0) {
            resetTokenRepository.delete(token);
            return RESET_TOKEN_ALREADY_EXPIRED_MESSAGE;
        }
        return RESET_TOKEN_VALID_MESSAGE;
    }
    public ResetToken getByToken(String token){
        return resetTokenRepository.findByToken(token);
    }

}
