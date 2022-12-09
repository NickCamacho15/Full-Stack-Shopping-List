package com.techelevator.model;

public class ItemList<S> {

    private int listId;
    private String listName;
    private int numOfItems;

    public ItemList(int listId, String listName, int numOfItems) {
        this.listId = listId;
        this.listName = listName;
        this.numOfItems = numOfItems;
    }

    public ItemList(int listId, String listName) {
        this.listId = listId;
        this.listName = listName;
    }

    public ItemList() {

    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public int getNumOfItems() {
        return numOfItems;
    }

    public void setNumOfItems(int numOfItems) {
        this.numOfItems = numOfItems;
    }
}
