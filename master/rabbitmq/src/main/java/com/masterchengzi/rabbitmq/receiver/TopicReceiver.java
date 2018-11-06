package com.masterchengzi.rabbitmq.receiver;
import com.masterchengzi.authserver.model.MyUser;
import com.masterchengzi.rabbitmq.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicReceiver {
	// queues是指要监听的队列的名字
	@RabbitListener(queues = RabbitConfig.TOPIC_QUEUE1)
	public void receiveTopic1(MyUser user) {
		System.out.println("【receiveTopic1监听到消息】" + user.toString());
	}
	@RabbitListener(queues = RabbitConfig.TOPIC_QUEUE2)
	public void receiveTopic2(MyUser user) {
		System.out.println("【receiveTopic2监听到消息】" + user.toString());
	}
}