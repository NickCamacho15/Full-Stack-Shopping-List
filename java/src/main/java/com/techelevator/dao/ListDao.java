package com.techelevator.dao;

import com.techelevator.model.List;

public interface ListDao {
    public List<List>getListsByGroup(String groupName);
}
