package ru.mail.knhel7.spring_boot_rest_auth_service.repo;

import org.springframework.stereotype.Repository;
import ru.mail.knhel7.spring_boot_rest_auth_service.model.Authorities;
import ru.mail.knhel7.spring_boot_rest_auth_service.model.Roles;
import ru.mail.knhel7.spring_boot_rest_auth_service.model.User;

import java.util.*;

@Repository
public class UserRepo {

    private static Map<Roles, HashSet<Authorities>> roles = new HashMap<>();
    static {
        roles.put(Roles.GUEST,  new HashSet<Authorities>());
        roles.put(Roles.USER,  new HashSet<Authorities>(List.of(Authorities.READ)));
        roles.put(Roles.STAFF, new HashSet<Authorities>(List.of(Authorities.READ, Authorities.WRITE)));
        roles.put(Roles.ADMIN, new HashSet<Authorities>(List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE)));
    }

    private static Map<String, User> users = new HashMap<>();
    static {
        users.put("user0",  new User("user0", "00000", Roles.ADMIN));
        users.put("user1",  new User("user1", "11111"));
        users.put("user2",  new User("user2", "22222", Roles.USER));
        users.put("user3",  new User("user3", "33333", Roles.STAFF));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        return users.containsKey(user) && Objects.equals(users.get(user).getPassword(), password)
                ? roles.get(users.get(user).getRole()).stream().sorted().toList()
                : new ArrayList<Authorities>();
    }

}
