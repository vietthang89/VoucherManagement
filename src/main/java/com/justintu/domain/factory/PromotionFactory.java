package com.justintu.domain.factory;

import com.justintu.domain.Promotion;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PromotionFactory {

    public static Promotion createWeeklyPromotion() {
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime endDate = today.plusDays(7);
        Promotion promotion = new Promotion("New Year Sale", true, today, endDate);
        return promotion;
    }

}
