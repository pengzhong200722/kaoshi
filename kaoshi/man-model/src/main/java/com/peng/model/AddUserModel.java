package com.peng.model;

import java.util.List;

/**
 * @Author: pengzhong
 * @Date: 2024-5-21 13:28
 * @Description: *
 */
public class AddUserModel {
    private String userId;
    private List<String>endpoint;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(List<String> endpoint) {
        this.endpoint = endpoint;
    }
}
