package com.altimetrik.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.producer.service.impl.CartProducerService;
import com.altimetrik.produer.service.ProductService;
import com.altimetrik.shared.dto.Product;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/shoppingcart")
@AllArgsConstructor
public class ShoppingCartController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CartProducerService cartProducerService;

	@GetMapping("/choose-product/{productId}")
	public ResponseEntity<String> chooseProduct(@PathVariable("productId") String productId) {
		Product product = productService.getProductById(productId);
		cartProducerService.sendCartItem(product);
		return ResponseEntity.ok("Product added to the shopping cart!");
	}

}
