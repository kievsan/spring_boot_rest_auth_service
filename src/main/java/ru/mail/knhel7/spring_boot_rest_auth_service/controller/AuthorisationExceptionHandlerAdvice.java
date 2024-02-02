package ru.mail.knhel7.spring_boot_rest_auth_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.mail.knhel7.spring_boot_rest_auth_service.exception.InvalidCredentials;
import ru.mail.knhel7.spring_boot_rest_auth_service.exception.UnauthorizedUser;

@RestControllerAdvice
public class AuthorisationExceptionHandlerAdvice {

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> handlerInvalidCredentials(InvalidCredentials ex){
        System.out.println(ex.getMessage());
        return new ResponseEntity<>("User name or password is empty", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> handlerUnauthorizedUser(UnauthorizedUser ex){
        System.out.println(ex.getMessage());
        return new ResponseEntity<>("Unknown user", HttpStatus.UNAUTHORIZED);
    }
}
