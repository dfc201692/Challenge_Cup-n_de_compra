package com.example.challenge.model;

// CouponRequest.java
import java.util.List;

public class CouponRequest {
    private List<String> itemIds;
    private int amount;

    public List<String> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<String> itemIds) {
        this.itemIds = itemIds;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

