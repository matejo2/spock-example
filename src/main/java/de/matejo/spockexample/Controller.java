package de.matejo.spockexample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @GetMapping("/users/1")
    public User getSingleUser() {
        return new User(1L, "foo", "bar");
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        var users = new ArrayList<User>();
        users.add(new User(1L, "foo", "bar"));
        return users;
    }
}
