package ru.mail.knhel7.spring_boot_rest_auth_service.exception;

public class UnauthorizedUser extends RuntimeException {

    public UnauthorizedUser(String msg) {
        super(msg);
    }
}
