package com.justintu.services.impl;

import com.justintu.domain.Promotion;
import com.justintu.dto.PromotionDTO;
import com.justintu.mapper.PromotionMapper;
import com.justintu.services.PromotionService;
import org.springframework.stereotype.Service;


@Service
public class PromotionServiceImpl implements PromotionService {
    public Promotion createPromotion(PromotionDTO dto) {
        Promotion promotion = PromotionMapper.toDbEntity(dto);
        return promotion;
    }
}
