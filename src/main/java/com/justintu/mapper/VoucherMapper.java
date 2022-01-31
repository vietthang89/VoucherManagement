package com.justintu.mapper;

import com.justintu.domain.Voucher;
import com.justintu.dto.VoucherDTO;
import org.modelmapper.ModelMapper;

public class VoucherMapper {

    public static VoucherDTO toDTO(Voucher voucher) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(voucher, VoucherDTO.class);
    }

    public static Voucher toDbEntity(VoucherDTO voucherDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(voucherDTO, Voucher.class);
    }
}
