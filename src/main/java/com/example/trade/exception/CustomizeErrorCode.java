package com.example.trade.exception;

/**
 * Created by codedrinker on 2019/5/28.
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode {

    RESOURCE_NOT_FOUND(401,"资源不存在"),
    NO_LOGIN(403, "当前操作需要登录，请登陆后重试"),
    SERVER_ERROR(404, "服务器崩了！");

    private Integer code;
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    CustomizeErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
