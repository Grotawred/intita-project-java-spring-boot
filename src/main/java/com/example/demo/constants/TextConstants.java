package com.example.demo.constants;

public interface TextConstants {

    String EMAIL_VERIFICATION_COMPLETE_MESSAGE =
            "Success!  Please, check your email for to complete your registration";

    String ALREADY_VERIFIED_EMAIL_MESSAGE = "This account has already been verified, please, login.";

    String EMAIL_VERIFIED_SUCCESS_MESSAGE =
            "Email verified successfully. Now you can login to your account";

    String INVALID_VERIFICATION_TOKEN_LOG_MESSAGE = "Invalid verification token";
    String INVALID_RESET_TOKEN_MESSAGE = "Invalid reset token";

    String USER_NOT_FOUND_MESSAGE = "User not found";

    String USER_WITH_EMAIL_MESSAGE = "User with email ";

    String ALREADY_EXIST_MESSAGE = " already exists";

    String TOKEN_ALREADY_EXPIRED_MESSAGE = "Token already expired";
    String RESET_TOKEN_ALREADY_EXPIRED_MESSAGE = "Link is already expired";

    String VALID_MESSAGE = "valid";
    String RESET_TOKEN_VALID_MESSAGE = "valid";
}
