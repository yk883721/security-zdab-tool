package com.yk.common.resp;

import com.yk.common.enums.AppCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(description = "通用表格响应返回对象")
public class PagedResult<T> {

    // 响应业务状态
    @ApiModelProperty("状态码")
    private Integer code;

    // 响应消息
    @ApiModelProperty("消息")
    private String message;

    // 响应中的数据
    @ApiModelProperty(value = "数据")
    private List<T> data;

    @ApiModelProperty(value = "总条数")
    private Long total;

    public static<T> PagedResult<T> ok(List<T> data, Long total) {
        return new PagedResult<>(data, total);
    }

    public static<T> PagedResult<T> ok() {
        return new PagedResult<>(null, 0L);
    }

    public static<T> PagedResult<T> errorMsg(String msg) {
        return new PagedResult<>(500, msg, null, 0L);
    }

    public static<T> PagedResult<T> error(Integer code, String message) {
        return new PagedResult<>(code, message, null, 0L);
    }

    public PagedResult() { }

    public PagedResult(Integer code, String message, List<T> data, Long total) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.total = total;
    }

    public PagedResult(List<T> data, Long total) {
        this.code = AppCodeEnum.SUCCESS.getCode();
        this.message = AppCodeEnum.SUCCESS.getErrorMessage();
        this.data = data;
        this.total = total;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
