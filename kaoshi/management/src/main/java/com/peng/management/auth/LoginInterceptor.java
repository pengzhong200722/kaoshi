package com.peng.management.auth;

import com.alibaba.fastjson.JSON;
import com.peng.model.AdminRole;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Base64;

/**
 * @Author: pengzhong
 * @Date: 2024-5-20 17:01
 * @Description: *
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String base64Role=request.getHeader("adminRole");
        if(StringUtils.isEmpty(base64Role))
        {
            //从请求头中拿到role信息，没有拿到返回false
            return false;
        }
        String role= new String(Base64.getDecoder().decode(base64Role));
        AdminRole adminRole=new AdminRole();
        try {
            adminRole= JSON.parseObject(URLDecoder.decode(role,"utf-8"), AdminRole.class);
        } catch (Exception e) {
            return false;
        }
        if(StringUtils.isEmpty(adminRole.getUserId()))
        {
            return false;
        }
        return true;
    }
}
