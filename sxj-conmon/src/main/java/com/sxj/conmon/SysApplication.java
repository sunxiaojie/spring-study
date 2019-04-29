package com.sxj.conmon;


import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;


@Configuration
@ComponentScan(basePackages = {"com.sxj.conmon"})
//@SpringBootApplication
//@ComponentScan(basePackages = {"com.sxj"})
//@Import(value={DozerConfig.class})
//@ServletComponentScan
@EnableAutoConfiguration
public class SysApplication {

	@Bean(name = "dozerBeanMapperFactory")
	public DozerBeanMapperFactoryBean createDozerFactory() throws Exception {
		DozerBeanMapperFactoryBean factory = new DozerBeanMapperFactoryBean();
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource[] appMappingConfig = resolver.getResources("classpath:dozer/**/**/*Mapping.xml");
		factory.setMappingFiles(appMappingConfig);
		return factory;
	}


}
