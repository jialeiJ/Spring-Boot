package spring.boot.sender;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Company:  Jaray.com
 *  @Author:  JiaLei
 *    @Date:  2018年5月25日
 *@Describe:  发送者
 */
@Component
public class HelloSender {
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	public void send(String name) {
		String context = "hello "+ name +" "+ new Date();
		System.out.println("Sender：" + context);
		this.rabbitTemplate.convertAndSend("hello", context);
	}

}
