package com.sxj.conmon;


import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.groovy.template.GroovyTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.autoconfigure.webservices.WebServicesAutoConfiguration;
import org.springframework.boot.autoconfigure.websocket.WebSocketAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;



@SpringBootApplication(exclude = {// 禁用spring-boot的一些组组件
		JpaRepositoriesAutoConfiguration.class,
		JmxAutoConfiguration.class, WebServicesAutoConfiguration.class, IntegrationAutoConfiguration.class,
		WebSocketAutoConfiguration.class,GroovyTemplateAutoConfiguration.class})
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
