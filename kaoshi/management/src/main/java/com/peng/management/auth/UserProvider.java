package com.peng.management.auth;

import com.alibaba.fastjson.JSON;
import com.peng.model.AddUserModel;
import com.peng.model.AdminRole;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Base64;

/**
 * Created by liujisheng on 2019/1/10.
 */
public class UserProvider {

    public AdminRole userInfo(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String base64Role=request.getHeader("adminRole");
        AdminRole adminRole=new AdminRole();
        try {
            adminRole= JSON.parseObject(URLDecoder.decode(base64Role,"utf-8"), AdminRole.class);
        } catch (Exception e) {
        }
        return adminRole;
    }

}
