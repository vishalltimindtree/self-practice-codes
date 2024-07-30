package com.day16session2.socialnetworking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.day16session2.socialnetworking.entity.Group;
import com.day16session2.socialnetworking.repository.GroupRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }

    public Group getGroupById(Long groupId) {
        return groupRepository.findById(groupId).orElseThrow(
                () -> new EntityNotFoundException("Group not found with id: " + groupId));
    }

}
