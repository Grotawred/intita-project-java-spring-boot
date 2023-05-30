package com.example.demo.handler;

import com.example.demo.handler.exception.PostNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class PostNotFoundExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<Object> handle(PostNotFoundException ex, WebRequest request) {
        return new ResponseEntity<Object>(
                "Post not found", new HttpHeaders(), HttpStatus.NOT_FOUND
        );
    }

}
