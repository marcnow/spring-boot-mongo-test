package de.adesso.hellospring.controller;

import de.adesso.hellospring.model.User;
import de.adesso.hellospring.model.dto.UserDto;
import de.adesso.hellospring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public User getUser(@PathVariable String userId) {
        return userService.getUser(userId);
    }

    @PostMapping
    public UserDto createUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String address) {
        return userService.createUser(firstName, lastName, address);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }
}
