package spring.boot.aop;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

@Aspect//使用@Aspect注解将一个java类定义为切面类
@Component
public class LogAspect {
	
	private Logger logger = Logger.getLogger(getClass());
	Long startTime = null, endTime = null;;
	
	@Pointcut("execution(public * spring.boot.controller..*.*(..))")
	public void log() {};
	
	@Before("log()")
	public void doBefore(JoinPoint joinPoint) throws Throwable{
		startTime = System.currentTimeMillis();
		//打印 Logback 内部状态
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(lc);
		
		//1、获取到请求
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		
		//2、记录请求内容
		logger.info("         URL = " + request.getRequestURL().toString());
		logger.info(" HTTP_METHOD = " + request.getMethod());
		logger.info("          IP = " + request.getRemoteAddr());
		logger.info("     ADDRESS = " + request.getLocalPort());
		logger.info("CLASS_METHOD = " + joinPoint.getSignature());
		logger.info("        ARGS = " + Arrays.toString(joinPoint.getArgs()));
	}
	
	@AfterReturning(returning = "result",pointcut = "log()")
	public void doAfterReturning(Object result) throws Throwable{
		endTime = System.currentTimeMillis();
		logger.info("RESPONSE = " + result);
		logger.info("Time Of Use = " + (endTime - startTime));
	}

}
