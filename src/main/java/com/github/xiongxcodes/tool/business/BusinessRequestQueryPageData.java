package com.github.xiongxcodes.tool.business;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BusinessRequestQueryPageData implements Serializable {
    private static final long serialVersionUID = -1418951256279888621L;
    @ApiModelProperty(value = "开始数")
    private Integer start;
    @ApiModelProperty(value = "页数")
    private Integer pageNum;
    @Max(value = 200, message = "每页记录数必须大于200")
    @Min(value = 1, message = "每页记录数必须大于0")
    @NotBlank(message = "每页记录数不能为空")
    @ApiModelProperty(value = "每页记录数")
    private Integer limit;
}
