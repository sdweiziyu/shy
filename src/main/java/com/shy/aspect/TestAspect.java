package com.shy.aspect;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
@Aspect
@Component
public class TestAspect {
	private static final Logger log = LoggerFactory.getLogger(TestAspect.class);
	ThreadLocal<Long> tl = new ThreadLocal<>();
	
	@Pointcut("execution(public * com.shy.controller..*.*(..))")
	public void testLog(){};
	@Before("testLog()")
	public void doBefore(JoinPoint joinPoint){
		tl.set(System.currentTimeMillis());
		// 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
	}
	@AfterReturning(returning="obj",pointcut="testLog()")
	public void doAfterReturning(Object obj){
		// 处理完请求，返回内容
        log.info("RESPONSE : " + obj);
        log.info("SPEND TIME : " + (System.currentTimeMillis() - tl.get())+"ms");
		
	}
}
