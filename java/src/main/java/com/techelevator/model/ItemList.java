package com.techelevator.model;

public class ItemList {
    String listName;
    private int listId;
    private int ownerId;
    private String contents;

    public ItemList(String listName, int listId, int ownerId)
    {
        this.listName = listName;
        this.listId = listId;
        this.ownerId = ownerId;
        this.contents = contents;
    }

    public ItemList(String listName, int listId, int ownerId, String contents)
    {
        this.listName = listName;
        this.listId = listId;
        this.ownerId = ownerId;
        this.contents = contents;
    }

    public ItemList()
    {
        this.listName = listName;
        this.listId = listId;
        this.ownerId = ownerId;
        this.contents = contents;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
