package com.masterchengzi.rabbitmq.receiver;

import com.masterchengzi.authserver.model.MyUser;
import com.masterchengzi.rabbitmq.config.RabbitConfig;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class FanoutReceiver {

	// queues是指要监听的队列的名字
	@RabbitListener(queues = RabbitConfig.FANOUT_QUEUE1)
	public void receiveTopic1(MyUser user) {
		log.info("【receiveFanout1监听到消息】"+user.toString());
	}

	@RabbitListener(queues = RabbitConfig.FANOUT_QUEUE2)
	public void receiveTopic2(MyUser user) {
		log.info("【receiveFanout2监听到消息】"+user.toString());
	}
}