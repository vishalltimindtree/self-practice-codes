package com.day16session2.socialnetworking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.day16session2.socialnetworking.entity.Group;
import com.day16session2.socialnetworking.entity.User;
import com.day16session2.socialnetworking.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/{userId}/groups/{groupId}")
    public ResponseEntity<Group> joinGroup(@PathVariable Long userId,
            @PathVariable Long groupId) {
        return new ResponseEntity<>(userService.joinGroup(userId, groupId), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(userService.getUserByUserId(userId), HttpStatus.OK);
    }

}
