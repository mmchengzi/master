package com.masterchengzi.travelserver.config;

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

	@Pointcut("execution(public * com.masterchengzi.travelserver.controller.*.*(..))")
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
			log.info("===============请求内容===============");
			log.info("请求地址 : " + request.getRequestURL().toString());
			log.info("请求方式 : " + request.getMethod());
			log.info("客户端IP : " + request.getRemoteAddr());
			log.info("请求类方法 : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
			log.info("请求类方法参数 : " + Arrays.toString(joinPoint.getArgs()));
			log.info("===============请求内容===============");
		}


	}

	@AfterReturning(returning = "ret", pointcut = "webLog()")
	public void doAfterReturning(Object ret) throws Throwable {
		// 处理完请求，返回内容
		log.info("===============响应内容===============");
		log.info("响应内容 : " + ret);
		log.info("花费时间 : " + (System.currentTimeMillis() - startTime.get()));
		log.info("===============响应内容===============");
	}
}
