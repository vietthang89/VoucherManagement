package com.justintu.dto;

public class RedeemVoucherDTO {

    private String code;

    // doesn't need it now
    // private String cartCode;
    // private String userId;

    public RedeemVoucherDTO() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
