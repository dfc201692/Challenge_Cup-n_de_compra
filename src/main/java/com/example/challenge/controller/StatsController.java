package com.example.challenge.controller;

import com.example.challenge.model.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/coupon")
public class StatsController {

    @GetMapping("/stats")
    public List<Item> getTopItems() {
        List<Item> topItems = getTopFavoriteItems(); // Implementación para obtener los ítems más favoritos
        return topItems;
    }

    // Método ficticio para obtener los ítems más favoritos
    private List<Item> getTopFavoriteItems() {
        // Aquí iría la lógica para obtener los ítems más favoritos
        // Por ahora, se simularán algunos ítems aleatorios
        List<Item> topItems = new ArrayList<>();
        topItems.add(new Item("MLA1", "Descripción del MLA1", 100.0, 15)); // Ejemplo de un ítem con 15 favoritos
        topItems.add(new Item("MLA2", "Descripción del MLA2", 210.0, 10)); // Ejemplo de otro ítem con 10 favoritos
        // Puedes obtener los datos reales de tu base de datos o de la API de Mercado Libre
        return topItems;
    }
}
