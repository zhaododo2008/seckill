package com.seckill.analysis.core.handler;


import com.seckill.analysis.exception.GlobalException;
import com.seckill.analysis.resp.RespResult;
import com.seckill.analysis.resp.util.RespUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(value= Exception.class)
    @ResponseBody
    public RespResult handle(Exception e) {
        if (e instanceof GlobalException) {
            GlobalException globalException = (GlobalException) e;
            return RespUtil.error(globalException.getCode(), globalException.getMessage());
        } else {
            logger.error("异常信息："+e.getCause().getMessage());
            e.printStackTrace();
            return RespUtil.error(-1,buildErrorMsg(e.getCause().getMessage()));
        }
    }

    private String buildErrorMsg(String message){
        if(!StringUtils.isEmpty(message)){
            int index = message.indexOf("Duplicate entry");
            if(index != -1){
                String msg = message.replaceAll("Duplicate entry","保存错误：值 ");
                return msg.replaceAll("for key","重复在字段：");
            }
        }
        return message;
    }
}