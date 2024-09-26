package com.example.journalApp.controllers;


import com.example.journalApp.entities.User;
import com.example.journalApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers()
    {
        return userService.getAll();
    }

    @PostMapping
    public void createUser(@RequestBody User user)
    {
         userService.saveEntry(user);
    }

    @PutMapping("/{username}")
    public ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable String username)
    {
        User userInDb=userService.findByUserName(username);
        if(userInDb!=null)
        {
            userInDb.setUsername(user.getUsername());
            userInDb.setPassword(user.getPassword());
            userService.saveEntry(userInDb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
