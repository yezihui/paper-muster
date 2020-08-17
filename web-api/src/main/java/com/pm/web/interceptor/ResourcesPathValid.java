package com.pm.web.interceptor;

import com.pm.common.constants.RequestConstants;
import com.pm.common.exception.CoreExceptionEnum;
import com.pm.common.exception.ServiceException;
import com.pm.web.bean.WebLoginUser;
import com.pm.web.context.LoginUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Desc
 * @Author yejx
 * @Date 2020/6/7
 */
@Slf4j
@Component
public class ResourcesPathValid {

    @Resource
    private LoginUserService loginUserService;

    public boolean doValidate(HttpServletRequest request) {

        String token = this.getTokenFromRequest(request);

        String requestPath = request.getServletPath();

        return this.validatePath(requestPath, token);
    }

    private boolean validatePath(String requestPath, String token) {
        log.info("校验用户权限请求");
        loginUserService.getLoginUserByToken(token);
        return true;
    }

    /**
     * 获取请求中的token
     *
     * @param request HttpServletRequest
     * @return token
     * @author yejx
     * @date 2018/11/5 13:49
     */
    String getTokenFromRequest(HttpServletRequest request) {
        //获取token
        if (request == null) {
            //非http请求环境
            throw new ServiceException(CoreExceptionEnum.SERVICE_ERROR);
        }
        //如果请求是在http环境下，则有request对象
        String token = request.getHeader(RequestConstants.HEADER_TOKEN);
        if (!StringUtils.isEmpty(token)) {
            return token;
        } else {
            throw new ServiceException(CoreExceptionEnum.TOKEN_ILLEGAL);
        }
    }
}
