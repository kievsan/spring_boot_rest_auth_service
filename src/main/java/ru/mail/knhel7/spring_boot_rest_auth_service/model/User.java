package ru.mail.knhel7.spring_boot_rest_auth_service.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
public class User {

    @NotBlank
    @Size(min = 2, max = 20)
    private String username;

    @Setter
    @NotBlank
    @Size(min = 5, max = 20)
    private String password;

    @Setter
    @NotBlank
    private Roles role;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.role = Roles.GUEST;
    }

    public User(String username, String password, Roles role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public void setUsername(String username) {
        if (this.username == null || this.username.isEmpty()) {
            this.username = username;
        }
    }

    @Override
    public String toString() {
        return "User{" + username +
                ", '" + password + '\'' +
                ", " + role + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
