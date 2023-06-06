package com.example.demo.constants;

public interface Const {

    String MIDDLE_OF_URL_FOR_VERIFY_EMAIL = "/register/verifyEmail?token=";

    String LOG_INFO_ABOUT_VERIFY_EMAIL = "Click the link to verify your registration :  {}";

    String SUBJECT_FOR_EMAIL_LETTER = "Email Verification";

    String SENDER_NAME_EMAIL = "User Registration Portal Service";

    String SENDER_EMAIL = "javamail411@gmail.com";

    String ERROR = "error";

    String TEXT_FOR_COMPLETE_EMAIL_VERIFICATION = "Success!  Please, check your email for to complete your registration";

    String TEXT_FOR_SHOW_INFO_ABOUT_ALREADY_VERIFY_EMAIL = "This account has already been verified, please, login.";

    String TEXT_FOR_SUCCESS_VERIFIED_EMAIL = "Email verified successfully. Now you can login to your account";

    String TEXT_ABOUT_INVALID_VERIFICATION_TOKEN = "Invalid verification token";

    String URL_START = "http://";

    String TEXT_USER_NOT_FOUND = "User not found";

    String TEXT_USER_WITH_EMAIL = "User with email ";

    String TEXT_ALREADY_EXIST = " already exists";

    String TEXT_TOKEN_ALREADY_EXPIRED = "Token already expired";

    String TEXT_VALID = "valid";

}
