package com.xdemy.mobile_xdemy.exception;

import com.xdemy.mobile_xdemy.utils.JsonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

//class for handling exception
@ControllerAdvice
public class ExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @ResponseBody
    public JsonData handle(CusException e){
        logger.error("[error here]{}", e);
        if(e instanceof CusException){
            CusException cusException = (CusException) e;
            return JsonData.bulidError(cusException.getCode(), cusException.getMsg());
        }
        else{
            return JsonData.bulidError("Unknown error occur");
        }
    }

}
