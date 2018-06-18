package spring.boot.sender;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JaraySender {
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	public void send(int i) {
		String context = "hello "+ i +" "+ new Date();
		System.out.println("Sender：" + context);
		this.rabbitTemplate.convertAndSend("jaray", context);
	}

}
