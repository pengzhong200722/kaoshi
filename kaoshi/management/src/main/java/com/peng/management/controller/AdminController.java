package com.peng.management.controller;

import com.alibaba.fastjson.JSON;
import com.peng.management.auth.UserProvider;
import com.peng.management.common.DateUtils;
import com.peng.model.AddUserModel;
import com.peng.model.AdminRole;
import com.peng.model.Resp;
import com.peng.model.ServiceStatus;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: pengzhong
 * @Date: 2024-5-20 16:45
 * @Description: *
 */
@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {
    /*
     添加用户
      */
    @PostMapping("/addUser")
    public Resp addUser(@RequestBody AddUserModel addUserModel) throws Exception{
        Resp resp = new Resp();
        if(addUserModel==null)
        {
            resp.setCode(ServiceStatus.FAIL.getCode());
            resp.setMsg("对象不能为空");
            return resp;
        }
        FileOutputStream fos = null;
        try {
            String filePath = "data/user" + DateUtils.nowyyyyMMDDHHmmss() + ".txt";
            fos = FileUtils.openOutputStream(new File(filePath), true);
            String jsonstr= JSON.toJSONString(addUserModel);
            fos.write((jsonstr + "\r\n").getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            fos.close();
        }
        return resp;
    }
    /*
 添加用户
  */
    @PostMapping("/user/{id}")
    public Resp visitUser(@PathVariable("id") String id) throws Exception{
        Resp resp = new Resp();
        UserProvider userProvider = new UserProvider();
        AdminRole adminRole = userProvider.userInfo();
        if(adminRole==null||!adminRole.getUserId().equals("123456"))
        {
            resp.setCode(ServiceStatus.FAIL.getCode());
            resp.setMsg("没有权限");
            return resp;
        }
        AddUserModel addUserModel=new AddUserModel();
        addUserModel.setUserId("123456");
        List<String> endlist=new ArrayList<>();
        endlist.add(id);
        addUserModel.setEndpoint(endlist);
        resp.setData(addUserModel);
        return resp;
    }
}
