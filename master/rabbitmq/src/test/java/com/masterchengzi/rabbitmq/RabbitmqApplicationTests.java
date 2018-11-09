package com.masterchengzi.rabbitmq;

import com.masterchengzi.authserver.model.MyUser;
import com.masterchengzi.rabbitmq.sender.DirectSender;
import com.masterchengzi.rabbitmq.sender.FanoutSender;
import com.masterchengzi.rabbitmq.sender.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {

	@Autowired
	private FanoutSender fanoutSender;
	@Autowired
	private TopicSender  topicSender;
	@Autowired
	private DirectSender directSender;

	/**
	 * Fanout测试
	 * @throws Exception
	 */
	@Test
	public void testFanout() throws Exception {
		MyUser user=new MyUser();
		user.setName("pwl");
		for(int i =0;i<100;i++){
			user.setId(i);
			fanoutSender.send(user);
		}
	}
	/**
	 * TOPIC测试
	 * @throws Exception
	 */
	@Test
	public void testTopic() throws Exception {
		MyUser user=new MyUser();
		user.setId(1);
		user.setName("pwl");
		topicSender.send(user);
	}

	/**
	 * DIRECT测试
	 * @throws Exception
	 */
	@Test
	public void testDirect() throws Exception {
		MyUser user=new MyUser();
		user.setId(1);
		user.setName("pwl");
		directSender.send(user);
	}
}
