package com.sxj.conmon.controller;

import com.sxj.conmon.base.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* 异常信息统一拦截
* @author Sxj
* @date 2019/9/12
*/
@ControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseDTO handleException(Exception e){
        log.error("系统错误", e);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode("-1001");
        responseDTO.setMessage("UNKNOW_ERROR");
        return responseDTO;
    }
}
