package com.go.after.common.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 校验Obj数据的工具类
 *
 * @author Dong
 */
public class ValidatedUtil {


    /**
     * 返回实体错误信息
     *
     * @param obj
     * @param bindingResult
     * @return
     */
    public static Map<String, Object> errorObj(@Validated Object obj, BindingResult bindingResult) {
        //获取是否有错误信息
        boolean flag = bindingResult.hasErrors();
        Map<String, Object> mapError = null;
        if (flag) {
            mapError = new HashMap<String, Object>(10);
            //获取错误信息
            List<FieldError> ListError = bindingResult.getFieldErrors();
            for (FieldError fieldError : ListError) {
                //获取错误属性名
                String errorName = fieldError.getField();
                //获取错误信息
                String errorValue = fieldError.getDefaultMessage();
                //保存错误信息
                mapError.put(errorName, errorValue);
            }
        }
        return mapError;
    }


}
