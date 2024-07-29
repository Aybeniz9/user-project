package az.edu.turing.userproject.controller;

import az.edu.turing.userproject.domain.dto.UserDto;
import az.edu.turing.userproject.domain.entity.User;
import az.edu.turing.userproject.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import az.edu.turing.userproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @PostMapping("/create/profile")
    public void createUser(@RequestBody UserDto userDto) {
        userService.createUser(userDto);
    }

    @GetMapping("/get/profiles")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/get/profiles/{id}")
    public UserDto getUserById(@PathVariable UUID id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
    }
}
