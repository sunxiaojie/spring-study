package com.sxj.product;

import com.sxj.conmon.SysApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 启动器
 *
 */
@SpringBootApplication
//@ServletComponentScan
public class ProductApp {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SysApplication.class, args);
	}

}
