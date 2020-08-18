package com.pm.web.modular.auth.service;

import com.pm.common.bean.JwtToken;
import com.pm.entity.web.WebUserEntity;
import com.pm.model.web.ro.AuthPwdDto;
import com.pm.model.web.ro.LoginRo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pm.web.bean.UserResource;

import javax.servlet.http.HttpServletRequest;

/**
 * @Desc
 * @Author yejx
 * @Date 2020/6/7
 */
public interface IWebUserService extends IService<WebUserEntity> {

    JwtToken login(LoginRo loginRo, HttpServletRequest request);

    void logout();

    void modifyPassword(AuthPwdDto param);

    UserResource getUserResources();
}
