package com.sxj.conmon;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = {"com.sxj.conmon"})
//@SpringBootApplication
//@ComponentScan(basePackages = {"com.sxj"})
//@Import(value={DozerConfig.class})
//@ServletComponentScan
//@EnableAutoConfiguration
public class SysApplication {

//	@Bean(name = "dozerBeanMapperFactory")
//	public DozerBeanMapperFactoryBean createDozerFactory() throws Exception {
//		DozerBeanMapperFactoryBean factory = new DozerBeanMapperFactoryBean();
//		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//		Resource[] appMappingConfig = resolver.getResources("classpath:dozer/**/**/*Mapping.xml");
//		factory.setMappingFiles(appMappingConfig);
//		return factory;
//	}


}
