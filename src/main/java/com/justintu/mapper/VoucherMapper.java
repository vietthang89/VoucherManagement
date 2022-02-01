package com.justintu.mapper;

import com.justintu.domain.Voucher;
import com.justintu.dto.VoucherDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


/**
 * Make it component so can inject another dependencies if needed.
 */

@Component
public class VoucherMapper {
    ModelMapper modelMapper = new ModelMapper();

    public VoucherDTO toDTO(Voucher voucher) {
        return this.modelMapper.map(voucher, VoucherDTO.class);
    }

    public Voucher toDbEntity(VoucherDTO voucherDTO) {
        return this.modelMapper.map(voucherDTO, Voucher.class);
    }
}
