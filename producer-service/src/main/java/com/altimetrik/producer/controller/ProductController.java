package com.altimetrik.producer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.produer.service.ProductService;
import com.altimetrik.shared.dto.Product;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping
	public ResponseEntity<?> getAllProducts() {
		List<Product> productsList = productService.getAllProducts();
		if (productsList.size() > 0) {
			return ResponseEntity.ok(productsList);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Products not available");
		}
	}
	
	@GetMapping("/getProductById")
	public ResponseEntity<?> getProductDetails(@RequestParam("id") String productId) {
		Product product = productService.getProductById(productId);
		if (product != null) {
			return ResponseEntity.ok(product);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Products not available");
		}
	}
	
    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
    	productService.addProduct(product);
        return ResponseEntity.ok("Product added successfully!");
    }
}
