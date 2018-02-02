package com.sxj.conmon.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

import lombok.extern.slf4j.Slf4j;

/**
 * @author SXJ
 * @Date 2017年8月23日
 */
@Configuration
@Slf4j
public class DateSourceConfig {
	
	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;

	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;
	
	@Bean
	public DataSource druidDataSource(){
		log.info("DataSource 开始初始化");
		DruidDataSource datasource = new DruidDataSource();
		datasource.setUrl(url);
		datasource.setUsername(username);
		datasource.setPassword(password);
		datasource.setDriverClassName(driverClassName);
		datasource.setInitialSize(1);
		datasource.setMinIdle(1);
		datasource.setMaxActive(20);
		datasource.setMaxWait(60000);
		datasource.setTimeBetweenEvictionRunsMillis(60000);
		datasource.setMinEvictableIdleTimeMillis(300000);
		datasource.setValidationQuery("select 'x'");
		datasource.setTestWhileIdle(true);
		datasource.setTestOnBorrow(false);
		datasource.setTestOnReturn(false);
		datasource.setPoolPreparedStatements(true);
		datasource.setUseGlobalDataSourceStat(true);
		try {
			datasource.setFilters("stat,slf4j");
		} catch (SQLException e) {
			log.info("druid configuration initialization filter", e);
		}
		return datasource;
	}


}
