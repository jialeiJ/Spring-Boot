package spring.boot.client;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WebServiceClient {

	@Scheduled(cron="*/6 * * * * ?")
	public void schedulerTask() throws Exception {
		JaxWsDynamicClientFactory jdcf = JaxWsDynamicClientFactory.newInstance();
		Client client = jdcf.createClient("http://localhost:8090/wsDemo/ws?wsdl");
		Object[] objects = client.invoke("sayHello", "Jaray");
		System.out.println("***** " + objects[0].toString());
	}

}
