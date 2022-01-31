package com.justintu.mapper;

import com.justintu.domain.Condition;
import com.justintu.domain.Voucher;
import com.justintu.dto.ConditionDTO;
import com.justintu.dto.VoucherDTO;
import org.modelmapper.ModelMapper;

public class ConditionMapper {

    public static ConditionDTO toDTO(Condition condition) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(condition, ConditionDTO.class);
    }

    public static Condition toDbEntity(ConditionDTO conditionDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(conditionDTO, Condition.class);
    }
}
