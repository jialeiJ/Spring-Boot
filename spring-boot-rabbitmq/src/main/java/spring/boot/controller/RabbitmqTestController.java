package spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.boot.pojo.User;
import spring.boot.sender.FanoutSender;
import spring.boot.sender.HelloSender;
import spring.boot.sender.JaraySender;
import spring.boot.sender.ObjectSender;
import spring.boot.sender.TopicSender;

@RestController
public class RabbitmqTestController {
	@Autowired
	private HelloSender helloSender;
	@Autowired
	private JaraySender jaraySender;
	@Autowired
	private ObjectSender objectSender;
	@Autowired
	private TopicSender topicSender;
	@Autowired
	private FanoutSender fanoutSender;
	
	@RequestMapping("/hello")
	public String hello(@RequestParam String name) {
		helloSender.send(name);
		return "发送成功";
	}
	
	@RequestMapping("/jaray")
	public void oneToMany() throws Exception {
		for (int i=0;i<100;i++){
			jaraySender.send(i);
		}
	}
	
	@RequestMapping("/object")
	public void object() throws Exception {
		User user = new User("Jaray", "25");
		objectSender.send(user);
	}
	
	@RequestMapping("/topic")
	public void topic() throws Exception {
		topicSender.send1();
		topicSender.send2();
	}
	
	@RequestMapping("/fanout")
	public void fanout() throws Exception {
		fanoutSender.send();
	}

}
