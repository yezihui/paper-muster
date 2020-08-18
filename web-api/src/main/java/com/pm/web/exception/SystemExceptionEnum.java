package com.pm.web.exception;

import com.pm.common.exception.AbstractBaseExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * 系统管理模块异常,直接抛出即可，框架自动捕获
 * 异常代码范围(300-399)
 * </p>
 *
 * @author Shawn Deng
 * @date 2018/10/22 20:23
 */
@Getter
@AllArgsConstructor
public enum SystemExceptionEnum implements AbstractBaseExceptionEnum {

    /**
     * 用户名不存在
     */
    SYSTEM_USER_NOT_EXIST(301, "用户不存在"),

    /**
     * 用户名已存在
     */
    SYSTEM_USER_NAME_EXIST(302, "用户名已存在"),

    /**
     * 新增失败
     */
    ADD_FAIL(303, "新增失败"),

    /**
     * 编辑失败
     */
    EDIT_FAIL(304, "编辑失败"),

    /**
     * 删除用户失败
     */
    REMOVE_FAIL(305, "删除失败"),

    /**
     * 重置密码失败
     */
    RESET_USER_FAIL(306, "重置密码失败"),

    /**
     * 设置用户角色列表失败
     */
    SET_USER_ROLES_FAIL(307, "设置用户角色列表失败"),

    /**
     * 角色不存在
     */
    ROLE_NOT_EXIST(308, "角色不存在"),

    /**
     * 菜单不存在
     */
    MENU_NOT_EXIST(309, "菜单不存在"),

    /**
     * 权限不存在
     */
    OPERATION_NOT_EXIST(310, "权限不存在"),

    /**
     * 权限编码重复
     */
    OPERATION_CODE_REPEAT(311, "权限编码重复"),

    /**
     * 操作日志不存在
     */
    OPERATION_LOG_NO_EXIST(312, "操作日志不存在"),

    /**
     * 手机号已被绑定
     */
    SYSTEM_USER_PHONE_EXIST(313, "手机号已被绑定"),
    ;


    private Integer code;

    private String message;
}
