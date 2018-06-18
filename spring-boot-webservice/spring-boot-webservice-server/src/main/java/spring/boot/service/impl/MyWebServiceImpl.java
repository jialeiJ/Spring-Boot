package spring.boot.service.impl;

import javax.jws.WebService;

import spring.boot.service.MyWebService;


/**
 * @Company:  Jaray.com
 *  @Author:  JiaLei
 *    @Date:  2018年6月4日
 *    BZ: 注解中加上targetNamespace和endpointInterface防止业务类和接口不在 同一包下导致查询不到相关方法报错
 *    targetNamespace：命名为接口所在包的反向命名赋值
 *    endpointInterface：接口所在的包名
 */
@WebService(targetNamespace="http://service.boot.spring/",serviceName="sayHello",endpointInterface="spring.boot.service.MyWebService")
public class MyWebServiceImpl implements MyWebService {

	@Override
	public String sayHello(String name) {
		System.out.println("调用成功");
		String context = "Hello "+name;
		return context;
	}

}
