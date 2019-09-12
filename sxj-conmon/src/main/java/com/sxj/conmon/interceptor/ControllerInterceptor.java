package com.sxj.conmon.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
/**
 * @author SXJ
 * @Date 2017年8月23日
 */
@Aspect
@Component
@Slf4j
public class ControllerInterceptor {

	@Pointcut(value="execution(* com.sxj.*.web.*.*(..))")
	public void aspect() {}

	@Around("aspect()")
	private Object methodInterceptor(ProceedingJoinPoint pj) throws Throwable{
		log.debug("执行拦截器方法：methodInterceptor");
		return pj.proceed();
	}

}
