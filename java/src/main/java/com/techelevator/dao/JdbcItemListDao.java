package com.techelevator.dao;

import com.techelevator.model.ItemList;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcItemListDao implements ItemListDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcItemListDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ItemList> getListsByGroup(String groupName) {
       final String sql = "SELECT l.list_id, l.list_name, l.num_of_items\n" +
               "\tFROM lists l\n" +
               "\tJOIN groups as g ON l.group_id = g.group_id\n" +
               "\tWHERE group_name = ?\n" +
               "\tORDER BY list_name;";

        final SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql, groupName);
        List<ItemList> listOfItemLists = new ArrayList<>();
        while (results.next()) {
            ItemList itemList = mapRowToLists(results);
            listOfItemLists.add(itemList);
        }
        return listOfItemLists;

    }

    private ItemList mapRowToLists(SqlRowSet sqlRowSet) {
        ItemList itemList = new ItemList();
       itemList.setListId(sqlRowSet.getInt("list_id"));
       itemList.setListName(sqlRowSet.getString("list_name"));
       itemList.setNumOfItems(sqlRowSet.getInt("num_of_items"));
        return itemList;
    }
}
