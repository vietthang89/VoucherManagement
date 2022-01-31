package com.justintu.api.exception;

public class VoucherNotFoundException extends AbstractException {

    public VoucherNotFoundException(String code) {
        super(code);
    }
}
