package com.techelevator.dao;

import com.techelevator.model.Item;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
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
        final String sql = "\tSELECT i.item_id, i.item_name, i.quantity, i.list_id\n" +
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

    @Override
    public boolean addItem(int listId, String itemName,int quantity) {
        final String sql = "\tINSERT INTO items(\n" +
                "\titem_name, quantity, list_id)\n" +
                "\tVALUES (?, ?, ?)\n" +
                "\tRETURNING item_id;";

        try{
            Integer newItemId = jdbcTemplate.queryForObject(sql, Integer.class, itemName, quantity, listId);
            return true;
        }catch (DataAccessException e){
            System.out.println(e.getMessage());
            return false;
        }
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
