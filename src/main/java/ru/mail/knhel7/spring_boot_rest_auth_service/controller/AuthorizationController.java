package ru.mail.knhel7.spring_boot_rest_auth_service.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.mail.knhel7.spring_boot_rest_auth_service.model.Authorities;
import ru.mail.knhel7.spring_boot_rest_auth_service.model.User;
import ru.mail.knhel7.spring_boot_rest_auth_service.service.AuthorizationService;

import java.util.List;

@RestController
@RequestMapping("/")
public class AuthorizationController {
    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("authorize")
    public List<Authorities> getAuthorities(@Validated User user) {
        return service.getAuthorities(user);
    }
}
