package com.pm.web.config;

import com.pm.web.context.LoginContext;
import com.pm.web.context.LoginUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * <p>
 * 上下文配置
 * </p>
 */
@Configuration
@Import(LoginUserService.class)
public class ContextConfig {

    /**
     * 获取当前用户服务的便捷工具
     */
    @Bean
    public LoginContext loginContext(LoginUserService loginUserService) {
        return new LoginContext(loginUserService);
    }
}
