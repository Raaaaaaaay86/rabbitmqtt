package com.example.rabbitmqtt.utils.rabbitmq;

import com.example.rabbitmqtt.toggle.RabbitMqSenderAbstraction;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "features.active", name = "sender", havingValue = "new")
public class NewRabbitMqSender implements RabbitMqSenderAbstraction {
	@Autowired
	RabbitTemplate rabbitTemplate;

	@Override
	public void send() {
		this.rabbitTemplate.convertAndSend("amq.topic", "latest_hello", "This is the new MQTT");
	}
}
