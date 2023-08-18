package com.example.demo.exception.resetTokenExceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ResetTokenExceptionHandler {
    @ExceptionHandler(TokenIsNotValid.class)
    public ModelAndView handleEmailIsAlreadyUsedException(TokenIsNotValid tokenIsNotValid){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:error_page");
        return modelAndView;
    }
    @ExceptionHandler(TokenIsNull.class)
    public ModelAndView handleEmailIsAlreadyUsedException(TokenIsNull tokenIsNull){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:error_page");
        return modelAndView;
    }
    @ExceptionHandler(UserDoesNotExistByEmail.class)
    public ModelAndView handleUserDoesNotExist(UserDoesNotExistByEmail userDoesNotExist){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:error_page");
        return modelAndView;
    }
    @ExceptionHandler(PasswordsDoNotMatch.class)
    public ModelAndView handlePasswordsDoNotMatch(PasswordsDoNotMatch passwordsDoNotMatch){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:error_page");
        return modelAndView;
    }
}
