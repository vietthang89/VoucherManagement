package com.justintu.api.rest.impl;

import com.justintu.api.rest.VoucherResource;
import com.justintu.domain.Voucher;
import com.justintu.dto.RedeemVoucherDTO;
import com.justintu.dto.VoucherDTO;
import com.justintu.services.VoucherService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/voucher")
@Api(description="Operations for creating and redemption voucher in online store")
public class VoucherResourceImpl implements VoucherResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(VoucherResourceImpl.class);
    private VoucherService voucherService;

    @Autowired
    public VoucherResourceImpl(final VoucherService voucherService) {
        this.voucherService = voucherService;
    }


    @PostMapping("/createVoucher")
    public String createVoucher(@RequestBody VoucherDTO dto) {
        return voucherService.generateVoucher(dto);
    }


    @PutMapping("/redeem")
    public boolean redeemVoucher(@RequestBody RedeemVoucherDTO dto) {
        return voucherService.redeemVoucher(dto.getCode());
    }

    @GetMapping("/getAllVouchers")
    public Iterable<Voucher>  getAllVouchers() {
        return voucherService.getAllVouchers();
    }
}
