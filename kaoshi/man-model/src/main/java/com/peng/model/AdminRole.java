package com.peng.model;

/**
 * @Author: pengzhong
 * @Date: 2024-5-21 10:43
 * @Description: *
 */
public class AdminRole {
    private String userId;
    private String accountName;
    private String role;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
