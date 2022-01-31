package com.justintu.api.exception;

public class VoucherAlreadyExpiredException extends AbstractException {
    public VoucherAlreadyExpiredException(String code) {
        super(code);
    }
}
