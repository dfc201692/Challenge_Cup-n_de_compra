package com.example.challenge.controller;

import com.example.challenge.model.Item;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.challenge.repository.ItemRepository;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/coupon")
public class StatsController {

    private static final Logger logger = Logger.getLogger(StatsController.class.getName());

    @Autowired
    private ItemRepository itemRepository; // Repositorio para acceder a los datos de los ítems


    @GetMapping("/stats")
    public List<Item> getTopItems() {
        List<Item> topItems = itemRepository.findTopFavoriteItems(5); // Donde 10 es el número de ítems superiores que deseas obtener
        logger.info("Se obtuvieron los items favoriteados");
        return topItems;
    }

}
