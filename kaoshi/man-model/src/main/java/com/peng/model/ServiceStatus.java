package com.peng.model;

/**
 * 状态
 */
public enum ServiceStatus {

    SUCCESS("0", "成功"),
    ERROR("1", "失败"),
    FAIL("205", "失败");
    private String code;

    private String detail;

    public String getCode() {
        return code;
    }

    public String getDetail() {
        return detail;
    }


    ServiceStatus(String code, String detail) {
        this.code = code;
        this.detail = detail;
    }
}
