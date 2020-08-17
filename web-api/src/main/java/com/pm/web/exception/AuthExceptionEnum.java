package com.pm.web.exception;

import com.pm.common.exception.AbstractBaseExceptionEnum;

/**
 * <p>
 * 授权模块异常,直接抛出即可，框架自动捕获
 * 异常代码范围(203-299)
 * </p>
 */
public enum AuthExceptionEnum implements AbstractBaseExceptionEnum {

    /**
     * 用户名或者密码错误
     */
    LOGIN_ERROR(203, "用户名或者密码错误"),

    /**
     * 用户已被禁用
     */
    LOGIN_USER_DISABLE(204, "用户已被禁用"),
    /**
     * 注销登录失败
     */
    LOGOUT_ERROR(206, "非法注销登录,请联系管理员"),
    /**
     * 密码错误次数过多，账号锁定中(半小时解除限制)
     */
    USER_LOCK_ERROR(205, "密码错误次数过多，账号锁定中(半小时解除限制)"),
    /**
     * 没有访问该资源的权限
     */
    NO_PERMISSION(207, "没有访问该资源的权限"),
    /**
     * 两次新密码输入不一致
     */
    NEW_PASSWORD_NOT_EQUAL(208, "两次新密码输入不一致"),

    /**
     * 旧密码错误
     */
    LOGIN_PASSWORD_ERROR(209, "旧密码错误"),

    /**
     * 新密码不符合密码规范
     */
    NEW_PASSWORD_NO_COMPLEX(210, "新密码不符合密码规范"),
    ;

    private Integer code;

    private String message;

    AuthExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
