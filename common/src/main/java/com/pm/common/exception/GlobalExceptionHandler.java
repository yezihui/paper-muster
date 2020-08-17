package com.pm.common.exception;

import com.pm.common.bean.data.ErrorResponseData;
import com.pm.common.bean.data.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ControllerAdvice
@Order(200)
@Slf4j
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    public ResponseData handleIllegalParamException(MethodArgumentNotValidException e) {
        log.error("请求参数验证错误：" + e);
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        if (!CollectionUtils.isEmpty(fieldErrors)) {
            String errMsg = (fieldErrors.get(0)).getField() + (fieldErrors.get(0)).getDefaultMessage();
            return new ErrorResponseData(CoreExceptionEnum.PARAM_INVALID.getCode(), errMsg);
        } else {
            return new ErrorResponseData(CoreExceptionEnum.PARAM_INVALID.getCode(), CoreExceptionEnum.PARAM_INVALID.getMessage());
        }
    }

    @ExceptionHandler({ServiceException.class})
    public ResponseData notFount(ServiceException e) {
        log.error("业务异常:", e);
        return new ErrorResponseData(e.getCode(), e.getErrorMessage());
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseData serverError(Exception e) {
        log.error("运行时异常:", e);
        return e instanceof HttpRequestMethodNotSupportedException ? new ErrorResponseData(CoreExceptionEnum.REQUEST_METHOD_ERROR.getCode(), CoreExceptionEnum.REQUEST_METHOD_ERROR.getMessage()) : new ErrorResponseData(CoreExceptionEnum.SERVICE_ERROR.getCode(), CoreExceptionEnum.SERVICE_ERROR.getMessage());
    }
}
