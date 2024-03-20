package com.example.challenge.model;

import java.util.List;

public class CouponRequest {
    private List<Long> itemIds;
    private double amount;

    public List<Long> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<Long> itemIds) {
        this.itemIds = itemIds;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
