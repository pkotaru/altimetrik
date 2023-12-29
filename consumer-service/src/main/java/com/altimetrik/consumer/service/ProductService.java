package com.altimetrik.consumer.service;

import java.util.List;

import com.altimetrik.consumer.entity.ProductEntity;
import com.altimetrik.shared.dto.Product;

public interface ProductService {
	 public List<Product> getAllProducts();
	 
	 public String chooseProduct(String ProductId);
	 
	 public ProductEntity saveProduct(ProductEntity product);

}
