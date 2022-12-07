package com.techelevator.controller;

import com.techelevator.dao.GroupDao;
import com.techelevator.model.Group;
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
    public List<Group> getGroupsByUser(Principal principal, @PathVariable String username)
    {return this.groupDao.getGroups(username);}

    @PostMapping("/addgroup")
    public boolean create(@RequestParam String username, @RequestParam String groupName){
        return this.groupDao.createGroup(username, groupName);
    }
}
