package com.masterchengzi.sharesrobot.config;

import lombok.extern.java.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * User zjc
 * Created with IntelliJ IDEA
 * Created on 2018-06-22 15:15
 * aop日志
 */
@Aspect
@Component
@Log
public class WebLogAspect {
	ThreadLocal<Long> startTime = new ThreadLocal<>();

	@Pointcut("execution(public * com.masterchengzi.sharesrobot.controller.*.*(..))")
	public void webLog() {
	}

	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		startTime.set(System.currentTimeMillis());
		// 接收到请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if (attributes != null&&attributes.getRequest()!=null) {
			HttpServletRequest request = attributes.getRequest();
			// 记录下请求内容
			log.info("URL : " + request.getRequestURL().toString());
			log.info("HTTP_METHOD : " + request.getMethod());
			log.info("IP : " + request.getRemoteAddr());
			log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
			log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
		}
	}

	@AfterReturning(returning = "ret", pointcut = "webLog()")
	public void doAfterReturning(Object ret) throws Throwable {
		// 处理完请求，返回内容
		log.info("RESPONSE : " + ret);
		log.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
	}

}
