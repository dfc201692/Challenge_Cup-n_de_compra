package com.example.challenge.model;

import java.util.List;

public class CouponResponse {
    private List<Long> itemIds;
    private double total;

    public CouponResponse(List<Long> itemIds, double total) {
        this.itemIds = itemIds;
        this.total = total;
    }

    public List<Long> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<Long> itemIds) {
        this.itemIds = itemIds;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

