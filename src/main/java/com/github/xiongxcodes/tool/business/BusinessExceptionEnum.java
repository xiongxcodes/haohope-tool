package com.github.xiongxcodes.tool.business;

public enum BusinessExceptionEnum {
    SUCCESS("0", "ok"), UNKNOWERR("-1", "未知错误");

    private String errcode;
    private String errmsg;

    BusinessExceptionEnum(String errcode, String errmsg) {
        this.errcode = errcode;
        this.errmsg = errmsg;
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
