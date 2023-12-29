package com.altimetrik.producer.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.altimetrik.produer.service.ProductService;
import com.altimetrik.shared.dto.Product;

@Service
public class ProductServiceImpl implements ProductService {

	private final Map<String, Product> products = new HashMap<>();

	public ProductServiceImpl() {
		Product product1 = new Product("1", "Apple IPhone 8 plus", 999.99);
		Product product2 = new Product("2", "Samsung Note 10 ", 499.99);
		Product product3 = new Product("3", "Huawei P30 Pro", 79.99);

		addProduct(product1);
		addProduct(product2);
		addProduct(product3);
	}

	@Override
	public List<Product> getAllProducts() {
		return new ArrayList<>(products.values());
	}

	@Override
	public Product getProductById(String productId) {
		return products.get(productId);
	}

	@Override
	public void addProduct(Product product) {
		products.put(product.getId(), product);
	}

}
