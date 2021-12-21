package com.example.rabbitmqtt.controller;

import com.example.rabbitmqtt.toggle.RabbitMqSenderAbstraction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/msg")
public class SendMessageController {

	@Autowired
	RabbitMqSenderAbstraction rabbitMqSenderAbstraction;

	@GetMapping("/send")
	public String sendMessage() {
		rabbitMqSenderAbstraction.send();
		return "OKOK";
	}
}
