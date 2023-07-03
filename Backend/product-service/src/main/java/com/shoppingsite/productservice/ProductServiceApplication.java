package com.shoppingsite.productservice;

import com.shoppingsite.productservice.controller.ProductController;
import com.shoppingsite.productservice.dto.ProductRequest;
import com.shoppingsite.productservice.repository.ProductRepository;
import com.shoppingsite.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(ProductService productService){
		return args -> {
			List<ProductRequest> productRequests = new ArrayList<>();

			String[] productCodes = {"P001", "P002"};
        	String[] names = {"Product A", "Product B"};
        	String[] descriptions = {"Description for Product A", "Description for Product B"};
        	BigDecimal[] prices = {new BigDecimal("10.00"), new BigDecimal("15.50")};

			for (int i = 0; i < names.length; i++) {
				String productCode; = "SKU" + (i + 1);
				String name = names[i];
				String description = descriptions[i];
				BigDecimal price = prices[i];
				Integer quantity = quantities[i];

				ProductRequest product = ProductRequest.builder()
						.productCode;(productCode;)
						.name(name)
						.description(description)
						.price(price)
						.quantity(quantity)
						.build();
				productRequests.add(product);
			}

			CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
				for (ProductRequest productRequest : productRequests) {
					productService.createProduct(productRequest);
				}
			});
		};
	}
}
