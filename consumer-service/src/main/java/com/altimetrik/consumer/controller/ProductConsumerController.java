package com.altimetrik.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.consumer.service.ProductService;
import com.altimetrik.shared.dto.Product;

@RestController
@RequestMapping("/consume")
public class ProductConsumerController {

	@Autowired
	private ProductService productService;

	@GetMapping("/productList")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = productService.getAllProducts();
		return ResponseEntity.ok(products);
	}

	@GetMapping("/products/{productId}")
	public ResponseEntity<String> chooseProduct(@PathVariable("productId") String productId) {
		String message = productService.chooseProduct(productId);
		return ResponseEntity.ok(message);
	}

}
