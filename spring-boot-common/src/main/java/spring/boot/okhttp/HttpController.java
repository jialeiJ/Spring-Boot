package spring.boot.okhttp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Company:  Jaray.com
 *  Author:  JiaLei
 *    Date:  2018年5月18日
 *    TODO:  TODO
 */
@RestController
public class HttpController {
	
	@RequestMapping("/http")
	public void Http(@RequestParam String name) {
		for(int i=0; i<300; i++) {
			System.out.println("name = " + name);
		}
	}

}
