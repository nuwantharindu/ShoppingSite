package com.shoppingsite.inventoryservice.service;

import com.shoppingsite.inventoryservice.dto.InventoryRequest;
import com.shoppingsite.inventoryservice.dto.InventoryResponse;
import com.shoppingsite.inventoryservice.dto.InventoryUpdateRequest;
import com.shoppingsite.inventoryservice.dto.InventoryUpdateResponse;
import com.shoppingsite.inventoryservice.model.Inventory;
import com.shoppingsite.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public void createInventory(InventoryRequest inventoryRequest) {
        Inventory inventory = Inventory.builder()
                .skuCode(inventoryRequest.getSkuCode())
                .quantity(inventoryRequest.getQuantity())
                .build();

        inventoryRepository.save(inventory);
    }

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode){
        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map(inventory ->
                    InventoryResponse.builder()
                            .skuCode(inventory.getSkuCode())
                            .isInStock(inventory.getQuantity() > 0)
                            .build()
                ).toList();
    }

    public InventoryUpdateResponse updateInventory(String skuCode, InventoryUpdateRequest inventoryUpdateRequest) {
        Inventory inventory = inventoryRepository.findBySkuCode(skuCode);
        inventory.setQuantity(inventoryUpdateRequest.getQuantity());

        return this.mapToInventoryUpdateResponse(inventoryRepository.save(inventory));
    }

    private InventoryUpdateResponse mapToInventoryUpdateResponse(Inventory inventory){
        return  InventoryUpdateResponse.builder()
                .skuCode(inventory.getSkuCode())
                .quantity(inventory.getQuantity())
                .build();
    }
}
