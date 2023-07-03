package com.shoppingsite.inventoryservice.repository;

import com.shoppingsite.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findByProductCodeIn(List<String> productCode;);

    Inventory findByProductCodeIn(String productCode;);
}
