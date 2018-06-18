package spring.boot.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {
	
	@RabbitHandler
	public void helloreceive(String hello) {
		System.out.println("Receiver：" + hello);
	}

}
