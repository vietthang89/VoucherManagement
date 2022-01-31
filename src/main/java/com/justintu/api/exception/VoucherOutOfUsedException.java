package com.justintu.api.exception;

public class VoucherOutOfUsedException extends AbstractException {
    public VoucherOutOfUsedException(String code) {
        super(code);
    }
}
