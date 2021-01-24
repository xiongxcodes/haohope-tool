package com.github.xiongxcodes.tool.business;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BusinessResponseGridData<T> extends BusinessResponseData<Object> {
    private static final long serialVersionUID = -5711434464013012199L;
    @ApiModelProperty(value = "记录总数")
    private long total = 0;
    @ApiModelProperty(value = "当前页记录")
    private List<T> rows = new ArrayList<T>();

    protected BusinessResponseGridData(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    protected BusinessResponseGridData(long total, List<T> rows, Object data) {
        this.total = total;
        this.rows = rows;
        this.data = data;
    }

    public static <T> BusinessResponseGridData<T> instance(com.github.pagehelper.Page<T> page) {
        return new BusinessResponseGridData<T>(page.getTotal(), page);
    }

    public static <T> BusinessResponseGridData<T> instance(long total, List<T> rows) {
        return new BusinessResponseGridData<T>(total, rows);
    }

    public static <T> BusinessResponseGridData<T> instance(long total, List<T> rows, Object data) {
        return new BusinessResponseGridData<T>(total, rows, data);
    }
}