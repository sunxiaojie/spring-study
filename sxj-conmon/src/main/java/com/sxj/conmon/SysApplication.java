package com.sxj.conmon;


import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;



@SpringBootApplication
@ComponentScan(basePackages = {"com.sxj"})
//@Import(value={DozerConfig.class})
@ServletComponentScan
public class SysApplication {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SysApplication.class, args);
	}

	@Bean(name = "dozerBeanMapperFactory")
	public DozerBeanMapperFactoryBean createDozerFactory() throws Exception {
		DozerBeanMapperFactoryBean factory = new DozerBeanMapperFactoryBean();
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource[] appMappingConfig = resolver.getResources("classpath:dozer/**/**/*Mapping.xml");
		factory.setMappingFiles(appMappingConfig);
		return factory;
	}


}
