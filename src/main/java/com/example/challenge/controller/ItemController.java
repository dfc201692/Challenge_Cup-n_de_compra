package com.example.challenge.controller;

import com.example.challenge.model.Item;
import com.example.challenge.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;

@RestController
@RequestMapping("/items")
@Api(value = "Item Management System", description = "Operations pertaining to items in Item Management System")
public class ItemController {

    private static final Logger logger = Logger.getLogger(ItemController.class.getName());
    @Autowired
    private ItemService itemService;

    @GetMapping("/all")
    @ApiOperation(value = "View a list of all items", response = List.class)
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemService.getAllItems();
        logger.log(Level.INFO, "Trae todos los items de la base de datos");
        return ResponseEntity.ok(items);
    }

    @GetMapping("/search{id}")
    @ApiOperation(value = "Get an item by ID", response = Item.class)
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        Item item = itemService.getItemById(id);
        logger.log(Level.INFO, "Busqueda por ítem");
        return ResponseEntity.ok(item);
    }

    @PostMapping("/save")
    @ApiOperation(value = "Create a new item", response = Item.class)
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        Item newItem = itemService.saveItem(item);
        logger.log(Level.INFO, "Se creó un nuevo ítem");
        return ResponseEntity.ok(newItem);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete an item by ID")
    public ResponseEntity<?> deleteItem(@PathVariable Long id) {
        itemService.deleteItemById(id);
        logger.log(Level.INFO, "Se eliminó el ítem con ID: " + id);
        return ResponseEntity.ok().build();
    }
}

