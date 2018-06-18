package spring.boot.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SpringUtil implements ApplicationContextAware {
	
	private static ApplicationContext applicationContext = null;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if(SpringUtil.applicationContext == null) {
			SpringUtil.applicationContext = applicationContext;
			System.out.println("applicationContext="+applicationContext);
		}
		
	}
	
	
	/**
	 * TODO:  获取ApplicationContext对象
	 * @return ApplicationContext
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	
	public static Object getBean(String name) {
		return applicationContext.getBean(name);
	}
	
	public static <T> T getBean(Class<T> clazz) {
		return applicationContext.getBean(clazz);
	}
	
	public static <T> T getBean(String name, Class<T> clazz) {
		return applicationContext.getBean(name, clazz);
	}
	
	
	/**
	 * 功能描述：取得jdbcTemplate实例
	 * @return
	 */
	public static JdbcTemplate getJdbcTemplate(){
		return (JdbcTemplate)getBean("jdbcTemplate");
	}

}
