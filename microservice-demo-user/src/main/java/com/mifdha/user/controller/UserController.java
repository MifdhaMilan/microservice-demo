package com.mifdha.user.controller;

import com.mifdha.user.model.User;
import com.mifdha.user.request.UserRequest;
import com.mifdha.user.response.UserResponse;
import com.mifdha.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create-user")
    public User createUser(@RequestBody UserRequest userRequest) throws Exception {
        return userService.createUser(userRequest);
    }

    @GetMapping("/get-user/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @GetMapping("/get-all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping("/delete-user/{id}")
    public void DeleteUser(@PathVariable int id){
        userService.DeleteUser(id);
    }

//    @PutMapping("/edit-user")
//    public User editUser(@RequestBody User user){
//        return userService.editUser(user);
//    }
}
