package com.suntek.demo.base;

import com.suntek.pci.common.constant.Constants;
import com.suntek.pci.common.dto.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 陈俊杰
 */
@Primary
@ResponseBody
@Controller
@ControllerAdvice
@Slf4j
public class GlobalController implements ErrorController {


    private static final String ERROR_PATH = "/error";

    @ExceptionHandler
    public Response handleException(Exception e){
        log.error(e.getMessage() , e);
        Response response = new Response();
        response.getResponseStatusObject().setStatusCode(Constants.RETURN_CODE_ERROR);
        response.getResponseStatusObject().setStatusString("系统异常");
        return response;
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

}
