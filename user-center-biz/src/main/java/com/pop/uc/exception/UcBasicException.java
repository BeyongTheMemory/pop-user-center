package com.pop.uc.exception;

import com.pop.exception.ExceptionInfo;
import com.pop.exception.ExceptionInfoGetter;

/**
 * Created by xugang on 16/8/6.
 */
public class UcBasicException extends RuntimeException implements ExceptionInfoGetter{

    ExceptionInfo exceptionInfo;

    public UcBasicException(String msg){
        exceptionInfo = new ExceptionInfo(1001,msg);
    }

    public ExceptionInfo getInfo() {
        return exceptionInfo;
    }

    public ExceptionInfo getExceptionInfo() {
        return exceptionInfo;
    }

    public void setExceptionInfo(ExceptionInfo exceptionInfo) {
        this.exceptionInfo = exceptionInfo;
    }
}
