package com.sxj.conmon.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * 异常信息统一拦截

 * @author: Sxj
 * @date: 19-7-31
 **/
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public void validationErrorHandler(MethodArgumentNotValidException ex) {
        // 同样是获取BindingResult对象，然后获取其中的错误信息
        // 如果前面开启了fail_fast，事实上这里只会有一个信息
        //如果没有，则可能又多个
//        List<String> errorInformation = ex.getBindingResult().getAllErrors()
//                .stream()
//                .map(ObjectError::getDefaultMessage)
//                .collect(Collectors.toList());
//        return new ResultInfo<>(400, errorInformation.toString(), null);
        log.error(ex.toString());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public void constraintViolationExceptionHandle(ConstraintViolationException ex) {
        // 同样是获取BindingResult对象，然后获取其中的错误信息
        // 如果前面开启了fail_fast，事实上这里只会有一个信息
        //如果没有，则可能又多个
//        List<String> errorInformation = ex.getBindingResult().getAllErrors()
//                .stream()
//                .map(ObjectError::getDefaultMessage)
//                .collect(Collectors.toList());
//        return new ResultInfo<>(400, errorInformation.toString(), null);
        log.error(ex.toString());
    }
}
