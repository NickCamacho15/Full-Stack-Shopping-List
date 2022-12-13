package com.techelevator.controller;

import com.techelevator.dao.GroupDao;
import com.techelevator.model.Group;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")
public class GroupController {
    private GroupDao groupDao;
    public GroupController(GroupDao groupDao){
        this.groupDao = groupDao;
    }

    @GetMapping("/groups/{username}")
    public List<Group> getGroupsByUser(@PathVariable String username)
    {return this.groupDao.getGroups(username);}


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addgroup")
    public boolean create(@RequestParam String username, @RequestParam String groupName){
        return this.groupDao.createGroup(username, groupName);
    }

    @PreAuthorize("permitAll()")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/groups/{groupId}/adduser/{userId}")
    public boolean update(@PathVariable int groupId, @PathVariable int userId){
        return this.groupDao.addUserToGroup(userId, groupId);
    }
}
