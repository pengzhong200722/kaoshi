package com.peng.management.handler;

import com.peng.model.Resp;
import com.peng.model.ServiceStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@ControllerAdvice(annotations = {RestController.class, Controller.class})
@ResponseBody
public class DefaultGlobalExceptionHandler {

    /**
     * 全局异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Resp otherExceptionHandler(Exception ex) {
        Resp resp=new Resp();
        resp.setMsg("系统繁忙");
        resp.setCode(ServiceStatus.ERROR.getCode());
        return resp;
    }
}
