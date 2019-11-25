package com.suntek.demo.base;

import com.suntek.pci.common.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.Locale;
import java.util.function.Supplier;


/**
 * @author txq
 */
public class BaseController {

    private static final int SUCCESSFUL_MESSAGE_CODE = 0 ;

    @Autowired
    protected MessageSource messageSource;

    protected Response response(String messageCode) {
        return response(messageCode, (Object) null);
    }

    protected Response response(String messageCode, Object resultObject) {
        Response jr = new Response<>();
        jr.setResponseResult(resultObject);
        jr.getResponseStatusObject().setStatusCode(messageCode != null ? Integer.parseInt(messageCode) : SUCCESSFUL_MESSAGE_CODE);
        jr.getResponseStatusObject().setStatusString(messageSource.getMessage(jr.getResponseStatusObject().getStatusCode() + "", null, Locale.CHINESE));
        return jr;
    }

    protected <R> Response<R> response(int messageCode, Supplier<R> supplier) {
        Response<R> jr = new Response<>();
        jr.setResponseResult(supplier.get());
        jr.getResponseStatusObject().setStatusCode(messageCode);
        jr.getResponseStatusObject().setStatusString(messageSource.getMessage(jr.getResponseStatusObject().getStatusCode()+"", null, Locale.CHINESE));
        return jr;
    }
    protected <R> Response<R> response(R responseResult) {
        Response<R> jr = new Response<>();
        jr.setResponseResult(responseResult);
        jr.getResponseStatusObject().setStatusCode(SUCCESSFUL_MESSAGE_CODE);
        jr.getResponseStatusObject().setStatusString(messageSource.getMessage(jr.getResponseStatusObject().getStatusCode()+"", null, Locale.CHINESE));
        return jr;
    }
    protected <R> Response<R> response(Supplier<R> supplier) {
        return response(SUCCESSFUL_MESSAGE_CODE, supplier);
    }

    protected <R> Response<R> responseVoid() {
        return responseVoid(() -> {
        });
    }

    protected <R> Response<R> responseVoid(Runnable callback) {
        return response((Supplier<R>) () -> {
            callback.run();
            return null;
        });
    }
}
