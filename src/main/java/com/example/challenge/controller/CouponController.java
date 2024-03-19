package com.example.challenge.controller;

import com.example.challenge.model.CouponRequest;
import com.example.challenge.model.CouponResponse;
import com.example.challenge.model.Item;
import com.example.challenge.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    private ItemService itemService; // Inyecta el service para acceso a los items

    @PostMapping("/")
    public CouponResponse calculateCoupon(@RequestBody CouponRequest request) {
        List<String> itemIds = request.getItemIds();
        int amount = request.getAmount();

        List<Item> items = itemService.getItemsByIds(itemIds); // Obtiene los items de la base de datos o la API

        List<String> selectedItems = selectItemsToMaximizeSpent(items, amount); // Usa la lógica optimizada
        double totalSpent = calculateTotalSpent(selectedItems, items);

        return new CouponResponse(selectedItems, totalSpent);
    }

    private List<String> selectItemsToMaximizeSpent(List<Item> items, int amount) {
        // Implementación optimizada usando el algoritmo de la mochila
        Collections.sort(items, (item1, item2) -> Double.compare(item2.getPrice(), item1.getPrice())); // Ordena por precio descendente

        List<String> selectedItems = new ArrayList<>();
        double total = 0;

        for (Item item : items) {
            if (total + item.getPrice() <= amount) {
                selectedItems.add(item.getItemId());
                total += item.getPrice();
            }
        }

        return selectedItems;
    }

    private double calculateTotalSpent(List<String> selectedItems, List<Item> items) {
        double totalSpent = 0;
        for (String itemId : selectedItems) {
            Item item = items.stream().filter(i -> i.getItemId().equals(itemId)).findFirst().get();
            totalSpent += item.getPrice();
        }
        return totalSpent;
    }
}
