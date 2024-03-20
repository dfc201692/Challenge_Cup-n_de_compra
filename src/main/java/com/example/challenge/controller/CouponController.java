package com.example.challenge.controller;

import com.example.challenge.model.CouponRequest;
import com.example.challenge.model.CouponResponse;
import com.example.challenge.model.Item;
import com.example.challenge.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    private ItemService itemService; // Inyecta el service para acceso a los items

    private static final Logger logger = Logger.getLogger(CouponController.class.getName());

    @PostMapping("/")
    public CouponResponse calculateCoupon(@RequestBody CouponRequest request) {
        List<Long> itemIds = request.getItemIds(); // Cambiado a List<Long>
        double amount = request.getAmount(); // Cambiado a double

        // Convertir los IDs de tipo String a tipo Long si es necesario
        List<Long> itemIdsLong = itemIds.stream()
                .map(Long::valueOf)
                .collect(Collectors.toList());

        List<Item> items = itemService.getItemsByIds(itemIdsLong); // Obtener los ítems por sus IDs

        List<Long> selectedItems = selectItemsToMaximizeSpent(items, amount); // Cambiado a List<Long>
        double totalSpent = calculateTotalSpent(selectedItems, items);

        return new CouponResponse(selectedItems, totalSpent);
    }

    private List<Long> selectItemsToMaximizeSpent(List<Item> items, double amount) {
        logger.info("Iniciando ordenamiento de ítems por precio descendente...");

        // Implementación optimizada usando el algoritmo de la mochila
        Collections.sort(items, Comparator.comparingDouble(Item::getPrice).reversed()); // Ordena por precio descendente

        logger.info("Ordenamiento finalizado.");

        List<Long> selectedItems = new ArrayList<>();  // Lista de ítems seleccionados
        double total = 0; // Gasto total inicializado en 0

        // Itera sobre los ítems ordenados
        for (Item item : items) {
            // Si añadir el ítem no excede el límite de gasto
            if (total + item.getPrice() <= amount) {
                selectedItems.add(item.getItemId()); // Agrega el ID del ítem a la lista de seleccionados
                total += item.getPrice(); // Añade el precio del ítem al gasto total
            }
        }

        return selectedItems; // Devuelve la lista de ítems seleccionados
    }

    private double calculateTotalSpent(List<Long> selectedItems, List<Item> items) {
        double totalSpent = 0;
        for (Long itemId : selectedItems) {
            Item item = items.stream().filter(i -> i.getItemId().equals(itemId)).findFirst().get();
            totalSpent += item.getPrice();
        }
        return totalSpent;
    }
}
