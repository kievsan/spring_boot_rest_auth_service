package ru.mail.knhel7.spring_boot_rest_auth_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.mail.knhel7.spring_boot_rest_auth_service.model.Authorities;
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
    public List<Authorities> getAuthorities(@RequestParam("username") String username,
                                            @RequestParam("password") String password) {
        return service.getAuthorities(username, password);
    }
}
