package com.example.challenge.model;

import java.util.List;

public class CouponResponse {
    private List<String> itemIds;
    private double total;

    public CouponResponse(List<String> itemIds, double total) {
        this.itemIds = itemIds;
        this.total = total;
    }

    public List<String> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<String> itemIds) {
        this.itemIds = itemIds;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

