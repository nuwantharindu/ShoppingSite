package com.shoppingsite.productservice.repository;

import com.shoppingsite.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p " +
            "WHERE lower(p.productcode) LIKE lower(concat('%', :query, '%')) " +
            "OR lower(p.name) LIKE lower(concat('%', :query, '%')) " +
            "OR lower(p.description) LIKE lower(concat('%', :query, '%'))")
    List<Product> findBySearchQuery(String query);
}
