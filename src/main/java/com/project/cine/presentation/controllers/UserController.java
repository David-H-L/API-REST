package com.project.cine.presentation.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;

import com.project.cine.application.dto.UserDto;
import com.project.cine.application.services.UserService;
import com.project.cine.domain.models.UserModel;

@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ArrayList<UserDto> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping()
    public UserModel saveUser(@RequestBody UserModel user) {
        return userService.saveUser(user);
    }

    @GetMapping(path = "/{id}")
    public UserDto getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteUser(@PathVariable("id") Long id) {
        return userService.deleteUser(id);
    }

}
