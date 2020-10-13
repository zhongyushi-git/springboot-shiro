package com.zys.springbootshiro.exception;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author zhongyushi
 * @date 2020/10/10 0010
 * @dec 异常捕获处理
 */

@ControllerAdvice
@Slf4j
public class MyExceptionHandler {

    //权限不足的处理
    @ExceptionHandler
    @ResponseBody
    public JSONObject ErrorHandler(AuthorizationException e) {
        log.error("权限不足！", e);
        JSONObject json=new JSONObject();
        json.put("status",false);
        json.put("msg","权限不足!");
        return json;
    }
}
