package com.yk.common.resp;

import com.yk.common.enums.AppCodeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class CommonResult<T> implements Serializable {

    @ApiModelProperty("状态码，非200均为失败")
    private Integer code;

    @ApiModelProperty("提示信息")
    private String msg;

    @ApiModelProperty("响应数据")
    private T data;

    private CommonResult<T> errorResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

    private CommonResult<T> errorResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        return this;
    }

    public static CommonResult error(int code, String msg) {
        CommonResult result = new CommonResult<>();
        return result.errorResult(code, msg);
    }

    public static <T> CommonResult<T> error(String msg) {
        CommonResult result = new CommonResult<>();
        return result.errorResult(400, msg);
    }

    public static CommonResult error(int code, String msg, Object data) {
        CommonResult result = new CommonResult<>();
        return result.errorResult(code, msg, data);
    }

    public static CommonResult error(AppCodeEnum enums) {
        return error(enums.getCode(), enums.getErrorMessage());
    }

    public static CommonResult error(AppCodeEnum enums, String message) {
        return error(enums.getCode(), message);
    }

    public static CommonResult success() {
        return success(null);
    }

    public static <T> CommonResult<T> success(T data) {
        CommonResult<T> result = new CommonResult<>();
        result.setCode(AppCodeEnum.SUCCESS.getCode());
        result.setMsg("操作成功");
        result.setData(data);
        return result;
    }
}

