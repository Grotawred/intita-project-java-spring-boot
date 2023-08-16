package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.ResetToken;
import com.example.demo.model.User;
import com.example.demo.model.dto.UserDTO;
import com.example.demo.repository.ResetTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.UUID;

import static com.example.demo.constants.TextConstants.*;

@Service
@RequiredArgsConstructor
public class ResetTokenService {
    private final ResetTokenRepository resetTokenRepository;
    private final UserMapper mapper;
    private final EmailService emailService;

    public void createAndSendResetLink(String email, String token){
        String link = "http://localhost/reset_password?token=" + token;
//          emailService.sendEmail(email, "Reset password", link);

    }

    public void saveToken(String token, UserDTO userDTO){
            User user = mapper.userDtoToUser(userDTO);
            ResetToken resetToken = new ResetToken(token, user);
            resetTokenRepository.save(resetToken);
    }
    public Boolean confirmPassword(String password, String confirmPassword){
        return password.equals(confirmPassword);
    }
    public void deleteToken(String token){
        ResetToken resetToken = resetTokenRepository.findByToken(token);
        resetTokenRepository.delete(resetToken);
    }

    public Boolean validateToken(String token){
        ResetToken resetToken = resetTokenRepository.findByToken(token);
        if (resetToken == null) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        if ((resetToken.getExpirationTime().getTime() - calendar.getTime().getTime()) <= 0) {
            resetTokenRepository.delete(resetToken);
            return false;
        }
        return true;
    }
    public ResetToken getByToken(String token){
        return resetTokenRepository.findByToken(token);
    }

}
