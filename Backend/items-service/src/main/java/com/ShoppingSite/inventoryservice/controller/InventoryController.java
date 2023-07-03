package com.shoppingsite.inventoryservice.controller;

import com.shoppingsite.inventoryservice.dto.InventoryRequest;
import com.shoppingsite.inventoryservice.dto.InventoryResponse;
import com.shoppingsite.inventoryservice.dto.InventoryUpdateRequest;
import com.shoppingsite.inventoryservice.dto.InventoryUpdateResponse;
import com.shoppingsite.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createInventory(@RequestBody InventoryRequest inventoryRequest){
        inventoryService.createInventory(inventoryRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> productCode){
        return inventoryService.isInStock(productCode);
    }

    @PutMapping("/{productCode}")
    @ResponseStatus(HttpStatus.OK)
    public InventoryUpdateResponse updateInventory(@PathVariable String productCode, @RequestBody InventoryUpdateRequest inventoryUpdateRequest) {
        return inventoryService.updateInventory(productCode, inventoryUpdateRequest);
    }
}
