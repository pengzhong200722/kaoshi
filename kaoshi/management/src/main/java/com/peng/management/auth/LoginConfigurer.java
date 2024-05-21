package com.peng.management.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: pengzhong
 * @Date: 2024-5-21 14:43
 * @Description: *
 */
@Configuration
public class LoginConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/build/**",
                        "/css/maps/**",
                        "/js/**",
                        "/images/**",
                        "/sys/**",
                        "/",
                        "/main",
                        "/table/**",
                        "/api/**",
                        //移除访问swagger页面时的单登录拦截
                        "/swagger-resources/**",
                        "/webjars/**",
                        "/v2/**",
                        "/swagger-ui.html/**",
                        "/validator/**",
                        "/error",
                        "/**/*.css",
                        "/index.html",
                        "/swagger-ui.html");
        //super.addInterceptors(registry);
    }
}
