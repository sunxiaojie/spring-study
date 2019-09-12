package com.sxj.conmon;


import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
* 框架包导入
* @author Sxj
* @date 2019/9/12
*/
@Configuration
@ComponentScan(basePackages = {"com.sxj.conmon"})
@ServletComponentScan(basePackages = {"com.sxj.conmon"})
public class SysApplication {}
