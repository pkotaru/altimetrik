package com.altimetrik.consumer.service.impl;

import java.util.List;

import com.altimetrik.consumer.entity.ProductEntity;
import com.altimetrik.consumer.repository.ProductRepository;
import com.altimetrik.consumer.service.ProductService;
import com.altimetrik.shared.dto.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServiceImpl implements ProductService {

	@Value("${producer.service.url}")
	private String producerServiceUrl;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		String url = producerServiceUrl + "/products";
		ResponseEntity<List<Product>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Product>>() {
				});
		return responseEntity.getBody();
	}

	@Override
	public String chooseProduct(String ProductId) {
		String url = producerServiceUrl + "/shoppingcart/choose-product/" + ProductId;
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
		return responseEntity.getBody();
	}

	@Override
	public ProductEntity saveProduct(ProductEntity productEntity) {
		return productRepository.save(productEntity);
	}

}
