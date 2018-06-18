package spring.boot.logback;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	private Logger logger = Logger.getLogger(getClass());
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(@RequestParam String name) {
		try {
			System.out.println(3/0);
		} catch (Exception e) {
			logger.error("异常", e);
		}
		
        return "Hello " + name;
    }

}
