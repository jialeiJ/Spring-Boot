package spring.boot.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface MyWebService {
	@WebMethod
	public String sayHello(String name);

}
