package com.yk.common.enums;

public enum AppCodeEnum {

    //成功 200
    SUCCESS(200,"操作成功"),
    BADREQUEST(400, "错误的请求"),

    TOKEN_ERROR(401, "token 无效"),

    URI_ERROR(400, "请求路径错误"),
    ;

    AppCodeEnum(Integer code, String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
    }

    Integer code;
    String errorMessage;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
