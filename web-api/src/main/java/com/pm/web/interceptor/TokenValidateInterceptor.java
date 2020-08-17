package com.pm.web.interceptor;

import com.pm.web.constants.AuthConstants;
import com.pm.web.context.LoginContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 校验TOKEN和用户权限拦截器
 * </p>
 *
 * @author Shawn Deng
 * @date 2018/11/5 19:54
 */
@Slf4j
public class TokenValidateInterceptor implements HandlerInterceptor {

    @Resource
    private ResourcesPathValid resourcesPathValid;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.debug("接口请求前置拦截器,拦截地址：{}", request.getServletPath());
        String requestUrl = request.getServletPath();
        if (requestUrl.equals(AuthConstants.AUTH_LOGIN_URL)) {
            log.debug("不拦截登录授权接口和默认错误接口");
            return true;
        }
        if (requestUrl.contains(AuthConstants.AUTH_RESOURCES_URL) ||
                requestUrl.contains(AuthConstants.AUTH_LOGOUT_URL) ||
                requestUrl.contains(AuthConstants.AUTH_MODIFY_PASSWORD_URL)) {
            //用户资源与修改资源不需要校验权限
            return true;
        }
        //校验请求头才能请求用户权限列表
        LoginContext.me().checkToken();
        return resourcesPathValid.doValidate(request);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
