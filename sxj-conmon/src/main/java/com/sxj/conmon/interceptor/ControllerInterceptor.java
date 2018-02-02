package com.sxj.conmon.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.sxj.conmon.base.ResponseDTO;
import com.sxj.conmon.util.ApplicationException;

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
		Object obj = null;
		Signature signature =  pj.getSignature();
		try {
			obj = pj.proceed();
			log.info(obj.toString());
			if (obj != null && obj instanceof ResponseDTO) {
				ResponseDTO generalResponse = (ResponseDTO) obj;
				generalResponse.setCode("200");
				generalResponse.setMessage("操作成功");
				return obj;
			}
		} catch (ApplicationException e) {
			Class<?> returnType = ((MethodSignature) signature).getReturnType();
			if(returnType.equals(Void.TYPE)){
				throw e;
			}else{
				obj = returnType.newInstance();
			}
			if (obj instanceof ResponseDTO) {
				ResponseDTO generalResponse = (ResponseDTO) obj;
				generalResponse.setCode(e.getCode());
				generalResponse.setMessage(e.getMessage());
				obj = generalResponse;
			}
			return obj;
		} catch (Exception e) {
			Class<?> returnType = ((MethodSignature) signature).getReturnType();
			if(returnType.equals(Void.TYPE)){
				throw e;
			}else{
				obj = returnType.newInstance();
			}
			if (obj instanceof ResponseDTO) {
				ResponseDTO generalResponse = (ResponseDTO) obj;
				generalResponse.setCode("-1001");
				generalResponse.setMessage("UNKNOW_ERROR");
				obj = generalResponse;
				log.info("UNKNOW_ERROR:" + e);
			}
			return obj;
		}
		return obj;
	}

}
