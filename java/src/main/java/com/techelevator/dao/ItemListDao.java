package com.techelevator.dao;

import com.techelevator.model.ItemList;

import java.util.List;

public interface ItemListDao {
    public List<ItemList> getListsByGroup(String groupName);
    public boolean createItemList(String listName, String groupName);
}
