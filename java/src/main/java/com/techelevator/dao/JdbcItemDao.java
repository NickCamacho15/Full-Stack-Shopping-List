package com.techelevator.dao;

import com.techelevator.model.Item;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;

public class JdbcItemDao implements ItemDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcItemDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Item> getItemsByListId(int listId) {
        return null;
    }

    private Item mapRowToItem(SqlRowSet sqlRowSet){
        Item item = new Item();
        item.setItemId(sqlRowSet.getInt("item_id"));
        item.setItemName(sqlRowSet.getString("item_name"));
        item.setQuantity(sqlRowSet.getInt("quantity"));
        item.setListId(sqlRowSet.getInt("list_id"));
        return item;
    }

}
