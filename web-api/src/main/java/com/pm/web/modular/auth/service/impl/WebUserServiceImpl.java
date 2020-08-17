package com.pm.web.modular.auth.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pm.common.bean.JwtToken;
import com.pm.common.exception.ServiceException;
import com.pm.entity.web.WebUserEntity;
import com.pm.model.web.ro.AuthPwdDto;
import com.pm.model.web.ro.LoginRo;
import com.pm.web.bean.WebLoginUser;
import com.pm.web.context.LoginContext;
import com.pm.web.context.LoginUserService;
import com.pm.web.exception.AuthExceptionEnum;
import com.pm.web.modular.auth.service.IWebUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.pm.common.util.ExceptionUtil;
import com.pm.common.util.HttpContextUtil;
import com.pm.mapper.web.WebUserMapper;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Desc
 * @Author yejx
 * @Date 2020/6/7
 */
@Slf4j
@Service
public class WebUserServiceImpl extends ServiceImpl<WebUserMapper, WebUserEntity> implements IWebUserService {

    @Resource
    private LoginUserService loginUserService;

    /**
     * 密钥加密工具
     */
    private PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();


    private WebUserEntity selectByUsername(String username) {
        return baseMapper.selectOne(new LambdaQueryWrapper<WebUserEntity>()
        .eq(WebUserEntity::getLoginName, username));
    }

    private WebLoginUser selectResourcesById(Long userId) {
        log.info("查询用户角色、权限、菜单");
        //用户信息
        WebLoginUser webLoginUser = new WebLoginUser();
        webLoginUser.setUserId(userId);
        return webLoginUser;
    }

    @Override
    public JwtToken login(LoginRo loginRo, HttpServletRequest request) {
        log.info("请求登录");
        WebUserEntity webUser = this.selectByUsername(loginRo.getUsername());
        //用户不存在
        ExceptionUtil.isNotNull(webUser, AuthExceptionEnum.LOGIN_ERROR);
        //用户已被禁用
        ExceptionUtil.isTrue(webUser.getIsEnabled(), AuthExceptionEnum.LOGIN_USER_DISABLE);
        //密码错误
        System.out.println(passwordEncoder.encode(loginRo.getPassword()));
        if (!passwordEncoder.matches(loginRo.getPassword(), webUser.getPassword())) {
            throw new ServiceException(AuthExceptionEnum.LOGIN_ERROR);
        }
        return login(webUser, request);
    }

    private JwtToken login(WebUserEntity webUser, HttpServletRequest request) {
        //查询用户角色、权限、菜单
        WebLoginUser webLoginUser = this.selectResourcesById(webUser.getId());
        webLoginUser.setUserName(webUser.getLoginName());
        webLoginUser.setNickName(webUser.getNickName());
        //更新登录时间
        this.updateUserLogin(webUser.getId(), HttpContextUtil.getIPAddress(request));
        //生成Token
        String jwtToken = loginUserService.generateToken(webUser.getId());
        webLoginUser.setAccessToken(jwtToken);

        loginUserService.put(webLoginUser);

        return JwtToken.builder().token(jwtToken).build();
    }

    /**
     * 更新用户登录信息
     *
     * @param userId
     * @param ip
     */
    private void updateUserLogin(Long userId, String ip) {
        WebUserEntity update = new WebUserEntity();
        update.setId(userId);
        update.setLastLoginIp(ip);
        update.setLastLoginTime(DateUtil.date());
        this.updateById(update);
    }

    @Override
    public void logout() {
        log.info("注销登录");
        WebLoginUser webLoginUser = LoginContext.me().getLoginUser();
        boolean flag = loginUserService.removeToken(webLoginUser.getAccessToken());
        ExceptionUtil.isTrue(flag, AuthExceptionEnum.LOGOUT_ERROR);
    }



    @Override
    public void modifyPassword(AuthPwdDto authPwdDto) {
        WebLoginUser webLoginUser = LoginContext.me().getLoginUser();
        boolean equals = StrUtil.equals(authPwdDto.getNewPwd(), authPwdDto.getReplyNewPwd());
        ExceptionUtil.isTrue(equals, AuthExceptionEnum.NEW_PASSWORD_NOT_EQUAL);
        WebUserEntity user = baseMapper.selectById(webLoginUser.getUserId());
        boolean equalPwd = passwordEncoder.matches(authPwdDto.getOldPwd(), user.getPassword());
        ExceptionUtil.isTrue(equalPwd, AuthExceptionEnum.LOGIN_PASSWORD_ERROR);
        boolean flag = ReUtil.isMatch("^(?=.*[0-9])(?=.*[a-zA-Z])(.{6,20})$", authPwdDto.getNewPwd());
        ExceptionUtil.isTrue(flag, AuthExceptionEnum.NEW_PASSWORD_NO_COMPLEX);
        String newPwd = passwordEncoder.encode(authPwdDto.getNewPwd());
        WebUserEntity updateEntity = WebUserEntity.builder()
                .id(webLoginUser.getUserId())
                .password(newPwd)
                .build();
        baseMapper.updateById(updateEntity);
        // 强制下线重新登录
        LoginContext.me().getLoginUserService().removeToken(webLoginUser.getAccessToken());
    }
}
