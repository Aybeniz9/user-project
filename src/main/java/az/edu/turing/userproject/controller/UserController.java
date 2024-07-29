package az.edu.turing.userproject.controller;

import az.edu.turing.userproject.domain.dto.UserDto;
import az.edu.turing.userproject.domain.entity.User;
import az.edu.turing.userproject.service.UserService;
import az.edu.turing.userproject.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private UserServiceImpl userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/newusers")
    public void createUser(@RequestBody UserDto userDto) {
        logger.info("Creating new user with username: {}", userDto.getUsername());
        userService.save(userDto);
        logger.info("User created successfully.");
    }

    @GetMapping("/all/users")
    public List<UserDto> getUsers() {
        logger.info("Fetching all users.");
        List<UserDto> users = userService.findAll();
        logger.info("Fetched {} users.", users.size());
        return users;
    }

    @GetMapping("/{id}")
    public Optional<UserDto> getUserById(@PathVariable UUID id) {
        logger.info("Fetching user with ID: {}", id);
        Optional<UserDto> userDto = userService.findById(id);
        if (userDto.isPresent()) {
            logger.info("User found: {}", userDto.get().getUsername());
        } else {
            logger.warn("User with ID: {} not found.", id);
        }
        return userDto;
    }

    @PutMapping("/{id}")
    public void updateUser(@RequestBody UserDto userDto) {
        logger.info("Updating user with ID: {}", userDto.getId());
        userService.update(userDto);
        logger.info("User updated successfully.");
    }

    @GetMapping("/count/users")
    public long getUserCount() {
        logger.info("Fetching user count.");
        long count = userService.count();
        logger.info("Total users count: {}", count);
        return count;
    }

    @PatchMapping("/age/{id}")
    public UserDto UpdateUserAge(@RequestBody UserDto userDto, @PathVariable UUID id) {
        logger.info("Updating age for user with ID: {}", id);
        UserDto updatedUser = userService.updateAge(userDto, id);
        logger.info("User age updated successfully for user: {}", updatedUser.getUsername());
        return updatedUser;
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable UUID id) {
        logger.info("Deleting user with ID: {}", id);
        userService.deleteById(id);
        logger.info("User deleted successfully.");
    }

    @DeleteMapping("/all")
    public void deleteAllUsers() {
        logger.info("Deleting all users.");
        userService.deleteAll();
        logger.info("All users deleted successfully.");
    }
}

//    @PostMapping("/create/profile")
//    public void createUser(@RequestBody UserDto userDto) {
//        userService.createUser(userDto);
//    }
//
//    @GetMapping("/get/profiles")
//    public List<UserDto> getAllUsers() {
//        return userService.getAllUsers();
//    }
//
//    @GetMapping("/get/profiles/{id}")
//    public UserDto getUserById(@PathVariable UUID id) {
//        return userService.getUserById(id);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void deleteUser(@PathVariable UUID id) {
//        userService.deleteUser(id);
//    }
