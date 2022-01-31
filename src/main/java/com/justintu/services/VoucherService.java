package com.justintu.services;

import com.justintu.domain.Condition;
import com.justintu.domain.Voucher;
import com.justintu.dto.VoucherDTO;

public interface VoucherService {

    String generateVoucher(VoucherDTO dto);

    boolean redeemVoucher(String code);

    Iterable<Voucher>  getAllVouchers();

}
