package com.sxj.product;

import com.sxj.conmon.SysApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 启动器
 *
 */
@SpringBootApplication(scanBasePackages = {"com.sxj.product"})
@MapperScan(basePackages = {"com.sxj.product.**.mapper"})
//@Configuration
//@ServletComponentScan
public class ProductApp {
	
	public static void main(String[] args) {
		SpringApplication.run(ProductApp.class, args);
	}

}
