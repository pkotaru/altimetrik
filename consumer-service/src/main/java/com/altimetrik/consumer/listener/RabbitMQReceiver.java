package com.altimetrik.consumer.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.altimetrik.consumer.entity.ProductEntity;
import com.altimetrik.consumer.mapper.ProductMapper;
import com.altimetrik.consumer.service.ProductService;
import com.altimetrik.shared.dto.Product;

@Component
public class RabbitMQReceiver{
	
	@Autowired
	private ProductService productService;
	
	@RabbitListener(queues = "test-queue")
	public void receiveMessage(Product product) {
		ProductEntity productEntity = ProductMapper.MAPPER.mapToProductEntity(product);
		productService.saveProduct(productEntity);
	}

}
