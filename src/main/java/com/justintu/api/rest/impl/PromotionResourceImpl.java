package com.justintu.api.rest.impl;


import com.justintu.api.rest.PromotionResource;
import com.justintu.domain.Promotion;
import com.justintu.services.PromotionService;
import com.justintu.dto.PromotionDTO;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/promotion")
public class PromotionResourceImpl implements PromotionResource {

//    @Autowired
//    PromotionService promotionService;
//
//    @PostMapping("/create")
//    @ApiOperation("Create a new promotion")
//    public ResponseEntity createPromotion(@RequestBody final PromotionDTO dto) {
//        Promotion promotion = promotionService.createPromotion(dto);
//
//        return new ResponseEntity<>(promotion, HttpStatus.OK);
//    }

}
