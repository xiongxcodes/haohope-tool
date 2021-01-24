package com.github.xiongxcodes.tool.business;

import lombok.Data;

@Data
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 3514495344859653338L;
    private String errcode;

    protected BusinessException() {
        super(BusinessExceptionEnum.UNKNOWERR.getErrmsg());
        this.errcode = BusinessExceptionEnum.UNKNOWERR.getErrcode();
    }

    protected BusinessException(String errmsg) {
        super(errmsg);
        this.errcode = BusinessExceptionEnum.UNKNOWERR.getErrcode();
    }

    protected BusinessException(Throwable cause) {
        super(cause);
        this.errcode = BusinessExceptionEnum.UNKNOWERR.getErrcode();
    }

    protected BusinessException(String errmsg, Throwable cause) {
        super(errmsg, cause);
        this.errcode = BusinessExceptionEnum.UNKNOWERR.getErrcode();
    }

    protected BusinessException(String errmsg, String errcode) {
        super(errmsg);
        this.errcode = errcode;
    }

    protected BusinessException(Throwable cause, String errcode) {
        super(cause);
        this.errcode = errcode;
    }

    protected BusinessException(String errmsg, Throwable cause, String errcode) {
        super(errmsg, cause);
        this.errcode = errcode;
    }

    public static BusinessException exception() {
        return new BusinessException();
    }

    public static BusinessException exception(String errmsg) {
        return new BusinessException(errmsg);
    }

    public static BusinessException exception(Throwable cause) {
        return new BusinessException(cause);
    }

    public static BusinessException exception(String errmsg, Throwable cause) {
        return new BusinessException(errmsg, cause);
    }

    public static BusinessException exception(String errmsg, String errcode) {
        return new BusinessException(errmsg, errcode);
    }

    public static BusinessException exception(Throwable cause, String errcode) {
        return new BusinessException(cause, errcode);
    }

    public static BusinessException exception(String errmsg, Throwable cause, String errcode) {
        return new BusinessException(errmsg, cause, errcode);
    }

}
