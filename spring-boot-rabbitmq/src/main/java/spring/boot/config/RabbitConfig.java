package spring.boot.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Company:  Jaray.com
 *  @Author:  JiaLei
 *    @Date:  2018年5月25日
 *@Describe:  队列配置表
 */
@Configuration
public class RabbitConfig {
	
	@Bean
	public Queue helloQueue() {
		return new Queue("hello");
	}
	
	@Bean
	public Queue jarayQueue() {
		return new Queue("jaray");
	}
	
	@Bean
	public Queue objectQueue() {
		return new Queue("object");
	}

}
