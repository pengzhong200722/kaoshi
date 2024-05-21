package com.peng.management.controller;


import com.peng.model.AddUserModel;
import com.peng.model.Resp;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AdminControllerTest {
    @Autowired
    private AdminController adminController;
    @Test
    public void addUser() throws Exception{
        AddUserModel addUserModel=new AddUserModel();
        addUserModel.setUserId("123456");
        List<String> endlist=new ArrayList<>();
        endlist.add("resource A");
        endlist.add("resource B");
        endlist.add("resource C");
        addUserModel.setEndpoint(endlist);
        Resp resp = adminController.addUser(addUserModel);
        Assert.assertNotNull(resp);
    }
}