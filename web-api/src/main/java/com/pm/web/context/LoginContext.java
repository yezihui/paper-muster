package com.pm.web.context;

import com.pm.common.constants.RequestConstants;
import com.pm.common.context.SpringContextHolder;
import com.pm.common.exception.CoreExceptionEnum;
import com.pm.common.exception.ServiceException;
import com.pm.web.bean.WebLoginUser;
import org.springframework.util.StringUtils;
import com.pm.common.util.HttpContextUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 登录用户信息上下文
 * </p>
 *
 * @author yejx
 * @date 2019-06-25 17:04
 */
public class LoginContext {

    private LoginUserService loginUserService;

    public LoginContext(LoginUserService loginUserService) {
        this.loginUserService = loginUserService;
    }

    /**
     * 获取自身INSTANCE
     */
    public static LoginContext me() {
        return SpringContextHolder.getBean(LoginContext.class);
    }

    public LoginUserService getLoginUserService() {
        return loginUserService;
    }

    /**
     * 获取当前用户的token
     * <p>
     * 先判断header中是否有Authorization字段，
     * 如果header中没有这个字段，则抛出没有登录用户异常
     */
    public String getCurrentUserToken() {
        HttpServletRequest request = HttpContextUtil.getRequest();
        if (request == null) {
            //非http请求环境
            throw new ServiceException(CoreExceptionEnum.SERVICE_ERROR);
        }
        //如果请求是在http环境下，则有request对象
        String authorization = request.getHeader(RequestConstants.HEADER_TOKEN);
        if (!StringUtils.isEmpty(authorization)) {
            return authorization;
        }
        // 在导出场景下token包含在param中
        authorization = request.getParameter(RequestConstants.HEADER_TOKEN);
        if (!StringUtils.isEmpty(authorization)) {
            return authorization;
        }
        throw new ServiceException(CoreExceptionEnum.TOKEN_ILLEGAL);
    }

    /**
     * 检查token是否合法,不合法则抛出异常
     *
     * @author yejx
     * @date 2018/10/24 17:15
     */
    public void checkToken() {
        String token = getCurrentUserToken();
        if (!loginUserService.checkToken(token)) {
            throw new ServiceException(CoreExceptionEnum.TOKEN_ILLEGAL);
        }
    }

    /**
     * 获取当前用户
     *
     * @return <T>
     * @author yejx
     * @date 2018/10/24 17:16
     */
    public WebLoginUser getLoginUser() {
        String token = getCurrentUserToken();
        return loginUserService.getLoginUserByToken(token);
    }
}
