package com.seckill.analysis.exception;

public class GlobalException extends RuntimeException {
    private Integer code;

    public GlobalException(String s) {
        super(s);
        this.code = -1;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
