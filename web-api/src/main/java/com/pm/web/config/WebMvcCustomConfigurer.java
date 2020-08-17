package com.pm.web.config;

import com.pm.web.interceptor.TokenValidateInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>
 *
 * </p>
 *
 * @author Shawn Deng
 * @date 2019-05-30 13:52
 */
@Configuration
@Import(TokenValidateInterceptor.class)
public class WebMvcCustomConfigurer implements WebMvcConfigurer {

    private TokenValidateInterceptor tokenValidateInterceptor;

    public WebMvcCustomConfigurer(TokenValidateInterceptor tokenValidateInterceptor) {
        this.tokenValidateInterceptor = tokenValidateInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] swaggerPathPatterns = new String[]{"/error", "/", "/favicon.ico", "/csrf", "/swagger-ui.html", "/webjars/**", "/swagger-resources/**", "/v2/api-docs", "/doc.html"};

        registry.addInterceptor(tokenValidateInterceptor)
                .excludePathPatterns(swaggerPathPatterns);

        WebMvcConfigurer.super.addInterceptors(registry);
    }
}