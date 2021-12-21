package com.example.rabbitmqtt.utils.rabbitmq;

import com.example.rabbitmqtt.toggle.RabbitMqSenderAbstraction;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "features.active", name = "sender", havingValue = "old")
public class RabbitMqSender implements RabbitMqSenderAbstraction {
	@Autowired
	RabbitTemplate rabbitTemplate;

	@Override
	public void send() {
		this.rabbitTemplate.convertAndSend("amq.topic", "latest_hello", "Heloooooooooooooooooooo");
	}
}
