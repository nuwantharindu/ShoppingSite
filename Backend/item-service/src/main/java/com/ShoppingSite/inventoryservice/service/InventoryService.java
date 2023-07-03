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
                .productcode
                (inventoryRequest.getProductcode())
                .quantity(inventoryRequest.getQuantity())
                .build();

        inventoryRepository.save(inventory);
    }

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> productcode
    ){
        return inventoryRepository.findByProductCodeIn(productcode
        ).stream()
                .map(inventory ->
                    InventoryResponse.builder()
                            .productcode
                            (inventory.getProductcode())
                            .isInStock(inventory.getQuantity() > 0)
                            .build()
                ).toList();
    }

    public InventoryUpdateResponse updateInventory(String productcode
    , InventoryUpdateRequest inventoryUpdateRequest) {
        Inventory inventory = inventoryRepository.findByProductCodeInSkuCode(productcode
        );
        inventory.setQuantity(inventoryUpdateRequest.getQuantity());

        return this.mapToInventoryUpdateResponse(inventoryRepository.save(inventory));
    }

    private InventoryUpdateResponse mapToInventoryUpdateResponse(Inventory inventory){
        return  InventoryUpdateResponse.builder()
                .productcode
                (inventory.getProductcode())
                .quantity(inventory.getQuantity())
                .build();
    }
}
