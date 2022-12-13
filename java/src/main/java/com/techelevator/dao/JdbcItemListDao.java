package com.techelevator.dao;

import com.techelevator.model.ItemList;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcItemListDao implements ItemListDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcItemListDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ItemList> getListsByGroup(int groupId) {
       final String sql = "SELECT l.list_id, l.list_name, l.num_of_items, g.group_id\n" +
               "\tFROM lists l\n" +
               "\tJOIN groups as g ON l.group_id = g.group_id\n" +
               "\tWHERE g.group_id = ?\n" +
               "\tORDER BY list_name;";

        final SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql, groupId);
        List<ItemList> listOfItemLists = new ArrayList<>();
        while (results.next()) {
            ItemList itemList = mapRowToLists(results);
            listOfItemLists.add(itemList);
        }
        return listOfItemLists;
    }

    @Override
    public boolean createItemList(String listName, int groupId){
        final String sql = "INSERT INTO lists(list_name, num_of_items, group_id)\n" +
                "VALUES (?, 0, ?)\n" +
                "RETURNING list_id;";

        try {
            Integer newListId = jdbcTemplate.queryForObject(sql, Integer.class, listName, groupId);
            return true;
        } catch (DataAccessException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private ItemList mapRowToLists(SqlRowSet sqlRowSet) {
        ItemList itemList = new ItemList();
       itemList.setListId(sqlRowSet.getInt("list_id"));
       itemList.setListName(sqlRowSet.getString("list_name"));
       itemList.setNumOfItems(sqlRowSet.getInt("num_of_items"));
       itemList.setGroupId(sqlRowSet.getInt("group_id"));
        return itemList;
    }
}
