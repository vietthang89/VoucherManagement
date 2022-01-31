package com.justintu.api.exception;

public class VoucherAlreadyAppliedException extends AbstractException {

    public VoucherAlreadyAppliedException(String code) {
        super(code);
    }
}
