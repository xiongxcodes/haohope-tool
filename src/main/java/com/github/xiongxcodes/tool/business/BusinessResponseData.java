package com.github.xiongxcodes.tool.business;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BusinessResponseData<T> implements Serializable {
    private static final long serialVersionUID = 1283569336822348850L;
    @ApiModelProperty(value = "错误码")
    private String errcode = BusinessExceptionEnum.SUCCESS.getErrcode();
    @ApiModelProperty(value = "错误信息")
    private String errmsg = "操作成功";
    @ApiModelProperty(value = "成功标识")
    private boolean success = true;
    @ApiModelProperty(value = "响应数据")
    protected T data;

    /**
     * 构造方法
     */
    protected BusinessResponseData() {

    }

    /**
     * 构造方法
     */
    protected BusinessResponseData(boolean success) {
        this.success = success;
    }

    /**
     * 构造方法
     * 
     * @param errmsg
     */
    protected BusinessResponseData(String errmsg, boolean success) {
        this.errmsg = errmsg;
        this.success = success;
    }

    /**
     * 构造方法
     * 
     * @param data
     */
    protected BusinessResponseData(T data, boolean success) {
        this.data = data;
        this.success = success;
    }

    /**
     * 构造方法
     * 
     * @param errmsg
     * @param data
     */
    protected BusinessResponseData(String errmsg, T data, boolean success) {
        this.errmsg = errmsg;
        this.data = data;
        this.success = success;
    }

    /**
     * 构造方法
     * 
     * @param errcode
     * @param errmsg
     */
    protected BusinessResponseData(String errcode, String errmsg, boolean success) {
        this.errcode = errcode;
        this.errmsg = errmsg;
        this.success = success;
    }

    /**
     * 构造方法
     * 
     * @param errcode
     * @param errmsg
     * @param data
     */
    protected BusinessResponseData(String errcode, String errmsg, T data, boolean success) {
        this.errcode = errcode;
        this.errmsg = errmsg;
        this.data = data;
        this.success = success;
    }

    /**
     * 响应成功数据
     * 
     * @return
     */
    public static BusinessResponseData<Object> ok() {
        return new BusinessResponseData<Object>();
    }

    /**
     * 响应成功数据
     * 
     * @param errmsg
     * @return
     */
    public static BusinessResponseData<Object> ok(String errmsg) {
        return new BusinessResponseData<Object>(errmsg, true);
    }

    /**
     * 响应成功数据
     * 
     * @param <T>
     * @param t
     * @return
     */
    public static <T> BusinessResponseData<T> ok(T t) {
        return new BusinessResponseData<T>(t, true);
    }

    /**
     * 响应成功数据
     * 
     * @param <T>
     * @param errmsg
     * @param t
     * @return
     */
    public static <T> BusinessResponseData<T> ok(String errmsg, T t) {
        return new BusinessResponseData<T>(errmsg, t, true);
    }

    /**
     * 响应失败数据
     * 
     * @param errmsg
     * @return
     */
    public static BusinessResponseData<Object> fail(String errmsg) {
        return new BusinessResponseData<Object>(BusinessExceptionEnum.UNKNOWERR.getErrcode(), errmsg, false);
    }

    /**
     * 响应失败数据
     * 
     * @param <T>
     * @param errmsg
     * @param t
     * @return
     */
    public static <T> BusinessResponseData<T> fail(String errmsg, T t) {
        return new BusinessResponseData<T>(BusinessExceptionEnum.UNKNOWERR.getErrcode(), errmsg, t, false);
    }

    /**
     * 响应失败数据
     * 
     * @param errcode
     * @param errmsg
     * @return
     */
    public static BusinessResponseData<Object> fail(String errcode, String errmsg) {
        return new BusinessResponseData<Object>(errcode, errmsg, false);
    }

    /**
     * 响应失败数据
     * 
     * @param <T>
     * @param errcode
     * @param errmsg
     * @param data
     * @return
     */
    public static <T> BusinessResponseData<T> fail(String errcode, String errmsg, T data) {
        return new BusinessResponseData<T>(errcode, errmsg, data, false);
    }

    /**
     * 响应失败数据
     * 
     * @param exception
     * @return
     */
    public static BusinessResponseData<Throwable> fail(Throwable exception) {
        return fail(exception, null);
    }

    /**
     * 响应失败数据
     * 
     * @param <T>
     * @param exception
     * @param data
     * @return
     */
    public static <T> BusinessResponseData<T> fail(Throwable exception, T data) {
        if (exception instanceof BusinessException) {
            BusinessException be = (BusinessException)exception;
            return new BusinessResponseData<T>(be.getErrcode(), be.getMessage(), data, false);
        } else {
            return new BusinessResponseData<T>(BusinessExceptionEnum.UNKNOWERR.getErrcode(),
                BusinessExceptionEnum.UNKNOWERR.getErrmsg(), data, false);
        }
    }
}
