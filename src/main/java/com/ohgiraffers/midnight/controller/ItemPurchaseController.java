package com.ohgiraffers.midnight.controller;

import com.ohgiraffers.midnight.model.dto.ItemPurchaseDTO;
import com.ohgiraffers.midnight.service.ItemPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item-purchases")
public class ItemPurchaseController {

    private final ItemPurchaseService itemPurchaseService;

    @Autowired
    public ItemPurchaseController(ItemPurchaseService itemPurchaseService) {
        this.itemPurchaseService = itemPurchaseService;
    }

    @GetMapping
    public ResponseEntity<List<ItemPurchaseDTO>> getAllItemPurchases() {
        List<ItemPurchaseDTO> itemPurchases = itemPurchaseService.findAllItemPurchases();
        return ResponseEntity.ok(itemPurchases);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPurchaseDTO> getItemPurchaseById(@PathVariable int id) {
        ItemPurchaseDTO itemPurchase = itemPurchaseService.findItemPurchaseById(id);
        return itemPurchase != null ? ResponseEntity.ok(itemPurchase) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ItemPurchaseDTO> createItemPurchase(@RequestBody ItemPurchaseDTO itemPurchaseDTO) {
        ItemPurchaseDTO createdItemPurchase = itemPurchaseService.createItemPurchase(itemPurchaseDTO);
        return ResponseEntity.ok(createdItemPurchase);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemPurchaseDTO> updateItemPurchase(@PathVariable int id, @RequestBody ItemPurchaseDTO itemPurchaseDTO) {
        ItemPurchaseDTO updatedItemPurchase = itemPurchaseService.updateItemPurchase(id, itemPurchaseDTO);
        return updatedItemPurchase != null ? ResponseEntity.ok(updatedItemPurchase) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItemPurchase(@PathVariable int id) {
        itemPurchaseService.deleteItemPurchase(id);
        return ResponseEntity.noContent().build();
    }
}
