package com.sxj.conmon.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xxl.job.core.executor.XxlJobExecutor;

import lombok.extern.slf4j.Slf4j;

/**
 * @author SXJ
 * @Date 2017年8月23日
 */
@Slf4j
@Configuration
@ConditionalOnExpression(value="${task.job.enabled}")
public class TaskConfig {

    @Value("${task.job.admin.addresses}")
    private String addresses;

    @Value("${task.job.executor.appname}")
    private String appname;

    @Value("${task.job.executor.ip}")
    private String ip;

    @Value("${task.job.executor.port}")
    private int port;

    @Value("${task.job.executor.logpath}")
    private String logpath;

    @Value("${task.job.accessToken}")
    private String accessToken;

    @Bean(initMethod = "start", destroyMethod = "destroy")
    public XxlJobExecutor xxlJobExecutor() {
        log.info("Initializing TaskConfig");
        XxlJobExecutor xxlJobExecutor = new XxlJobExecutor();
        xxlJobExecutor.setIp(ip);
        xxlJobExecutor.setPort(port);
        xxlJobExecutor.setAppName(appname);
        xxlJobExecutor.setAdminAddresses(addresses);
        xxlJobExecutor.setLogPath(logpath);
        xxlJobExecutor.setAccessToken(accessToken);
        return xxlJobExecutor;
    }

}
