package com.justintu.api.rest;

import com.justintu.domain.Voucher;
import com.justintu.dto.RedeemVoucherDTO;
import com.justintu.dto.VoucherDTO;
import io.swagger.annotations.ApiOperation;


public interface VoucherResource {

    @ApiOperation(value ="Create a voucher", response = String.class)
    String createVoucher(VoucherDTO dto);

    @ApiOperation(value ="Redeem a voucher", response = Boolean.class)
    boolean redeemVoucher(RedeemVoucherDTO dto);

    Iterable<Voucher>  getAllVouchers();
}
