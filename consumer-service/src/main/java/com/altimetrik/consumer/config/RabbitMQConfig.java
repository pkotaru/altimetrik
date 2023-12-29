package com.altimetrik.consumer.config;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class RabbitMQConfig {

    @Bean
    public MessageConverter messageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
	
	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		final RabbitTemplate rTemplate = new RabbitTemplate(connectionFactory);
		rTemplate.setMessageConverter(messageConverter(objectMapper()));
		return rTemplate; 
	}

}
