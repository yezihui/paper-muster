package com.pm.web.bean;

import lombok.Data;

/**
 * <p>
 * 当前用户的登录信息
 * </p>
 *
 * @author Shawn Deng
 * @date 2019-04-09 22:11
 */
@Data
public class WebLoginUser {

    /**
     * 账号id
     */
    private Long userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 访问令牌
     */
    private String accessToken;

}
