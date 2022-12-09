package com.techelevator.controller;


import com.techelevator.dao.ItemListDao;
import com.techelevator.model.ItemList;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")
public class ItemListController {

    private ItemListDao itemListDao;
    public ItemListController (ItemListDao itemListDao){
        this.itemListDao= itemListDao;
    }


    @GetMapping("/lists/{group_name}")
        public List<ItemList> getListsByGroupName(@RequestParam String groupName){
            return this.itemListDao.getListsByGroup(groupName);
        }



}
