package com.altimetrik.produer.service;

import java.util.List;
import com.altimetrik.shared.dto.Product;

public interface ProductService {
	List<Product> getAllProducts();
    Product getProductById(String productId);
    void addProduct(Product product);
}
