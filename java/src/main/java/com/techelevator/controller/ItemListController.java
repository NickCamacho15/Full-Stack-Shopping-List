package com.techelevator.controller;


import com.techelevator.dao.ItemListDao;
import com.techelevator.model.ItemList;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")
public class ItemListController {

    private ItemListDao itemListDao;
    public ItemListController (ItemListDao itemListDao){
        this.itemListDao= itemListDao;
    }


    @GetMapping("/lists/{groupName}")
        public List<ItemList> getListsByGroupName(@PathVariable String groupName){
            return this.itemListDao.getListsByGroup(groupName);
        }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/lists/{groupName}/addlist")
    public boolean createNewList(@PathVariable String groupName, @RequestParam String listName){
        return this.itemListDao.createItemList(listName, groupName);
    }




}
