package spring.boot.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import spring.boot.pojo.User;

@Component
@RabbitListener(queues = "object")
public class OjectReceiver {
	
	@RabbitHandler
	public void object(User user) {
	    System.out.println("Receiver object : " + user);
	}

}
