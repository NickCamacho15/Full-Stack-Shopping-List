package com.techelevator.model;

public class Item {
    private int itemId;
    private int quantity;
    private String itemName;
    private int listId;

    public Item(int itemId, int quantity, String itemName, int listId) {
        this.itemId = itemId;
        this.quantity = quantity;
        this.itemName = itemName;
        this.listId = listId;
    }

    public Item(){};

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }
}
