package spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootWebserviceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebserviceClientApplication.class, args);
	}
}
