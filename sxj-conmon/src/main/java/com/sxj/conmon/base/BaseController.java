package com.sxj.conmon.base;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.sxj.conmon.config.DozerConfig.DozerFactory;

/**
 * @author SXJ
 * @Date 2017年8月23日
 */
@Configuration
public class BaseController {
	
	@Autowired
	private DozerFactory factory;
	
	public Mapper getDozerMapper(){
		return factory.getMapper();
	}

}
