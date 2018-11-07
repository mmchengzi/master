package com.masterchengzi.rabbitmq.sender;

import com.masterchengzi.authserver.model.MyUser;
import com.masterchengzi.rabbitmq.config.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DirectSender {
	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void send(MyUser user) {
		this.rabbitTemplate.convertAndSend(RabbitConfig.DIRECT_EXCHANGE, "direct.pwl", user);
	}

}