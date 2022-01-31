package com.justintu.services;


import com.justintu.domain.Promotion;
import com.justintu.dto.PromotionDTO;


public interface PromotionService {

    Promotion createPromotion(PromotionDTO dto);
}
