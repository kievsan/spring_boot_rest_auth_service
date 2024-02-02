package ru.mail.knhel7.spring_boot_rest_auth_service.exception;

public class InvalidCredentials extends RuntimeException {

    public InvalidCredentials(String message) {
        super(message);
    }
}
