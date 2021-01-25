package com.github.xiongxcodes.tool.business;

public enum BusinessExceptionEnum {
    SUCCESS("000", "ok"), UNKNOWERR("-111", "未知错误"), NOTOKEN("111", "no token"), NOAUTH("222", "no auth"),
    TOKENERR("333", "token error");

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
