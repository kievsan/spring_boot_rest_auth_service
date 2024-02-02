package ru.mail.knhel7.spring_boot_rest_auth_service.service;

import org.springframework.stereotype.Service;
import ru.mail.knhel7.spring_boot_rest_auth_service.exception.UnauthorizedUser;
import ru.mail.knhel7.spring_boot_rest_auth_service.model.Authorities;
import ru.mail.knhel7.spring_boot_rest_auth_service.model.User;
import ru.mail.knhel7.spring_boot_rest_auth_service.repo.UserRepo;

import java.util.List;

@Service
public class AuthorizationService {

    private UserRepo repo;

    public AuthorizationService(UserRepo repo) {
        this.repo = repo;
    }

    public List<Authorities> getAuthorities(User user) {
        List<Authorities> userAuthorities = repo.getUserAuthorities(user.getUsername(), user.getPassword());
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user.getUsername());
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
