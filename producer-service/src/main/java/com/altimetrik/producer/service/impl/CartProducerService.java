package com.altimetrik.producer.service.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.altimetrik.shared.dto.Product;

@Service
public class CartProducerService {

	@Value("${rabbitmq.queue}")
	private String queueName;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendCartItem(Product product) {
		rabbitTemplate.convertAndSend(queueName, product);
	}
}
