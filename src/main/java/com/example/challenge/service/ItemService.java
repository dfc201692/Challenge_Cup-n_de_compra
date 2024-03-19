package com.example.challenge.service;

import com.example.challenge.model.Item;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
public class ItemService {

    private final Map<String, Item> items; // Repositorio ficticio de items

    public ItemService() {
        items = new HashMap<>();
        // Inicializar el "repositorio" con algunos items
        items.put("MLA1", new Item("MLA1", "Descripción del MLA1", 100.0, 1));
        items.put("MLA2", new Item("MLA2", "Descripción del MLA2", 210.0, 1));
        items.put("MLA3", new Item("MLA3", "Descripción del MLA3", 260.0, 1));
        items.put("MLA4", new Item("MLA4", "Descripción del MLA4", 80.0, 1));
        items.put("MLA5", new Item("MLA5", "Descripción del MLA5", 90.0, 1));
    }


    public List<Item> getItemsByIds(List<String> itemIds) {
        List<Item> itemsFound = new ArrayList<>();
        if (itemIds != null) {
        for (String itemId : itemIds) {
            Item item = items.get(itemId);
            if (item != null) {
                itemsFound.add(item);
            }
        }
        }
        return itemsFound;
    }
}
