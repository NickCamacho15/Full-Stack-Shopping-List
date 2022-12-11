package com.techelevator.dao;

import com.techelevator.model.Item;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcItemDao implements ItemDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcItemDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Item> getItemsByListId(int listId) {
        final String sql = "\tSELECT i.item_name, i.quantity, i.list_id\n" +
                "\tFROM items i\n" +
                "\tJOIN lists l ON l.list_id = i.list_id\n" +
                "\tWHERE l.list_id = ?\n" +
                "\tORDER BY item_name";
        final SqlRowSet result = this.jdbcTemplate.queryForRowSet(sql, listId);
        List<Item> listOfItems = new ArrayList<>();
        while(result.next()) {
            Item listItems = mapRowToItem(result);
            listOfItems.add(listItems);
        }
        return listOfItems;
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
