package com.justintu.mapper;

import com.justintu.domain.Promotion;
import com.justintu.dto.PromotionDTO;
import org.modelmapper.ModelMapper;

public class PromotionMapper {

    public static PromotionDTO toDTO(Promotion promotion) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(promotion, PromotionDTO.class);
    }

    public static Promotion toDbEntity(PromotionDTO promotionDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(promotionDTO, Promotion.class);
    }

}
