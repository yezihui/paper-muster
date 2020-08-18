package com.pm.web.modular.auth.controller;

import com.pm.common.bean.JwtToken;
import com.pm.common.bean.data.ResponseData;
import com.pm.common.exception.ServiceException;
import com.pm.model.web.ro.AuthPwdDto;
import com.pm.model.web.ro.LoginRo;
import com.pm.web.bean.UserResource;
import com.pm.web.constants.AuthConstants;
import com.pm.web.modular.auth.service.IWebUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @Desc
 * @Author yejx
 * @Date 2020/6/7
 */
@Api(tags = "Auth-授权相关接口")
@RestController
public class WebUserController {

    @Resource
    private IWebUserService iWebUserService;

    @PostMapping(AuthConstants.AUTH_LOGIN_URL)
    @ApiOperation(value = "登录接口", notes = "根据登录方式选择登录(登录成功可获取token)")
    public ResponseData<JwtToken> login(@RequestBody @Valid LoginRo loginRo, HttpServletRequest request) {
        JwtToken jwtToken = iWebUserService.login(loginRo, request);
        return ResponseData.success(jwtToken);
    }

    @PostMapping(AuthConstants.AUTH_LOGOUT_URL)
    @ApiOperation(value = "注销登录接口(Token)", notes = "注销Token，退出登录")
    public ResponseData logout() {
        try {
            iWebUserService.logout();
        } catch (ServiceException e) {
            // 注销登录 总是返回成功
            return ResponseData.success();
        }
        return ResponseData.success();
    }

    @GetMapping(AuthConstants.AUTH_RESOURCES_URL)
    @ApiOperation(value = "获取权限资源(Token)", notes = "获取权限资源")
    public ResponseData<UserResource> resources() {
        UserResource resources = iWebUserService.getUserResources();
        return ResponseData.success(resources);
    }

    @PostMapping(AuthConstants.AUTH_MODIFY_PASSWORD_URL)
    @ApiOperation(value = "修改安全密码(Token)", notes = "修改安全密码")
    public ResponseData modifyPassword(@RequestBody @Valid AuthPwdDto param) {
        iWebUserService.modifyPassword(param);
        return ResponseData.success();
    }
}
