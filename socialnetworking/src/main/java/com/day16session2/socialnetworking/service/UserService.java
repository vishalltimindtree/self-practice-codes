package com.day16session2.socialnetworking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.day16session2.socialnetworking.entity.Group;
import com.day16session2.socialnetworking.entity.User;
import com.day16session2.socialnetworking.repository.GroupRepository;
import com.day16session2.socialnetworking.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    public Group joinGroup(Long userId, Long groupId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new EntityNotFoundException("User not found with id: " + userId));

        Group group = groupRepository.findById(groupId).orElseThrow(
                () -> new EntityNotFoundException("Group not found with id: " + groupId));

        user.getGroups().add(group);
        group.getUsers().add(user);

        userRepository.save(user);

        return group;
    }

    public User getUserByUserId(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new EntityNotFoundException("User not found with id: " + userId));
    }

}
