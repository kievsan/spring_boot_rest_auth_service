package ru.mail.knhel7.spring_boot_rest_auth_service.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import ru.mail.knhel7.spring_boot_rest_auth_service.exception.InvalidCredentials;
import ru.mail.knhel7.spring_boot_rest_auth_service.exception.UnauthorizedUser;
import ru.mail.knhel7.spring_boot_rest_auth_service.model.Authorities;
import ru.mail.knhel7.spring_boot_rest_auth_service.repo.UserRepo;

import java.util.List;

@Service
public class AuthorizationService {

    private UserRepo repo;

    public AuthorizationService(UserRepo repo) {
        this.repo = repo;
    }

    public List<Authorities> getAuthorities(String username, String password) {
        if (isEmpty(username) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = repo.getUserAuthorities(username, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + username);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
