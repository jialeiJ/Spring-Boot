package spring.boot.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "jaray")
public class JarayReceiver1 {
	
	@RabbitHandler
	public void helloreceive(String hello) {
		System.out.println("JarayReceiver 1：" + hello);
	}

}
