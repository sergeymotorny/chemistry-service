package com.motorny.ss.chemistryservice.controller;

import com.motorny.ss.chemistryservice.dto.UserDto;
import com.motorny.ss.chemistryservice.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/u")
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public UserDto getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @PostMapping("/user")
    public UserDto createUser(@Valid @RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
    }

    @PutMapping("/user/{id}")
    public UserDto updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("id") Long id) {
        return userService.updateUser(userDto, id);
    }

    @PutMapping("/user/update/{id}")
    public ResponseEntity<String> updateUserAndRollback(@Valid @PathVariable("id") Long id, @RequestParam String name) {
        return new ResponseEntity<>(userService.updateUserAndRollback(id, name), HttpStatus.OK);
    }
}
