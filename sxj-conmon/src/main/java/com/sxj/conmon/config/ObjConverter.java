package com.sxj.conmon.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sxj.conmon.util.DateUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class ObjConverter {

    /**
     * @Description: form表单提交的时间格式转换

     * @Author: Sxj
     * @Date: 2019-05-14
     */
    @Bean
    public Converter<String, Date> dateConverter() {
        return new Converter<String, Date>() {
            @Override
            public Date convert(String source) {
                if (StringUtils.isEmpty(source))
                    return null;
                else
                    return DateUtil.parseDateYMDHS(source);
            }
        };
    }

    /**
     * @Description:  requestBody中的时间格式转换

     * @Author: Sxj
     * @Date: 2019-05-14
     */
    @Bean
    public ObjectMapper getObjectMapper(){
        return new ObjectMapper().setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }
}