package com.sxj.product.biz;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Service
@Validated
public class MyBiz {

    /**
     * service 方法层校验参数

     * @param name
     * @author: Sxj
     * @date: 19-7-31
     **/
    public void testValid(@NotNull String name) {
        System.out.println("valid 无效！");
    }
}
