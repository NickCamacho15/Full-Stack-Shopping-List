package com.techelevator.controller;


import com.techelevator.dao.ItemDao;
import com.techelevator.model.Item;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")
public class ItemController {
    private final ItemDao itemDao;
    public ItemController(ItemDao itemDao){
        this.itemDao = itemDao;
    }

    @GetMapping("items/{listId}")
    public List<Item> getItemsByListId(@PathVariable int listId){
        return this.itemDao.getItemsByListId(listId);
    }

}
