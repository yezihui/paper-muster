package com.pm.common.bean.data;

import lombok.Data;

@Data
public class ErrorResponseData extends ResponseData {

    private String exceptionClazz;

    public ErrorResponseData(String message) {
        super(false, DEFAULT_ERROR_CODE, message, null);
    }

    public ErrorResponseData(Integer code, String message) {
        super(false, code, message, null);
    }

    public ErrorResponseData(Integer code, String message, Object object) {
        super(false, code, message, object);
    }
}
