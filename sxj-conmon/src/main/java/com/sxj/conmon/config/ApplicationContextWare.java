package com.sxj.conmon.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

/**
 * @author SXJ
 * @Date 2017年8月23日
 */
@Configuration
@Slf4j
public class ApplicationContextWare implements ApplicationContextAware {
	
	private ApplicationContext applicationContext = null;

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		log.info("Initializing ApplicationContextWare");
		this.applicationContext = context;
	}
	
	public ApplicationContext getApplicationContext() {
		return this.applicationContext;
	}
	
}
