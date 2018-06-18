package spring.boot.logback;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SpringUtil {
	
	public static HttpServletRequest getRequest() {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		System.out.println("---"+request.getQueryString());//获取请求参数
		return request;
	}

}
