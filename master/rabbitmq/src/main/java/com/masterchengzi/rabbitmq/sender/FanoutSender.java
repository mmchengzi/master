package com.masterchengzi.rabbitmq.sender;
import com.masterchengzi.authserver.model.MyUser;
import com.masterchengzi.rabbitmq.config.RabbitConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {
	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send(MyUser user) {
		this.rabbitTemplate.convertAndSend(RabbitConfig.FANOUT_EXCHANGE, "", user);
	}
}