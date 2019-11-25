package com.suntek.demo.exception;


/**
 * @author TXQ
 */
public class BusinessException extends BaseException {

    protected String msgCode;

    public BusinessException(String msgCode) {
        super(msgCode);
        this.msgCode = msgCode;
    }

    public String getMsgCode() {
        return this.msgCode;
    }

    @Override
    public String toString() {
        return this.getMessage() ;
    }
}
