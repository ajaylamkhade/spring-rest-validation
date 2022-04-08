package com.javarunner.springrestvalidation.controller;

import com.javarunner.springrestvalidation.dto.UserRequest;
import com.javarunner.springrestvalidation.entity.User;
import com.javarunner.springrestvalidation.exception.UserNotFoundException;
import com.javarunner.springrestvalidation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest){
        return new ResponseEntity<>(userService.saveUser(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) throws UserNotFoundException {
        return ResponseEntity.ok(userService.getUser(id));
    }
}
