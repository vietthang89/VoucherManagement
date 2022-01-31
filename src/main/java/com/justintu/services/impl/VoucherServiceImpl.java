package com.justintu.services.impl;

import com.justintu.api.exception.VoucherAlreadyAppliedException;
import com.justintu.api.exception.VoucherAlreadyExpiredException;
import com.justintu.api.exception.VoucherNotFoundException;
import com.justintu.api.exception.VoucherOutOfUsedException;
import com.justintu.api.rest.impl.VoucherResourceImpl;
import com.justintu.constants.ConditionOperator;
import com.justintu.constants.ConditionType;
import com.justintu.constants.VoucherStatus;
import com.justintu.domain.Condition;
import com.justintu.domain.Promotion;
import com.justintu.domain.Voucher;
import com.justintu.dto.VoucherDTO;
import com.justintu.mapper.VoucherMapper;
import com.justintu.repositories.ConditionRepository;
import com.justintu.repositories.PromotionRepository;
import com.justintu.repositories.VoucherRepository;
import com.justintu.services.VoucherService;
import com.justintu.utils.VoucherCodeGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Transactional
public class VoucherServiceImpl implements VoucherService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VoucherServiceImpl.class);

    public static final int CODE_LENGTH = 6;

    @Autowired
    VoucherRepository voucherRepository;

    @Autowired
    PromotionRepository promotionRepository;

    @Autowired
    ConditionRepository conditionRepository;

    @Override
    public String generateVoucher(VoucherDTO dto) {
//        Optional<Promotion> promotion = promotionRepository.findById(promotionId);
//        if (promotion.isPresent()) {
            Voucher voucher = VoucherMapper.toDbEntity(dto);
            voucher.setCode(VoucherCodeGenerator.createRandomCode(CODE_LENGTH));
            voucher.setStatus(VoucherStatus.NEW);
            voucher.setCreatedTime(LocalDateTime.now());
            voucher.getConditions().stream().forEach(condition -> {
                    condition.setVoucher(voucher);
            });
            voucherRepository.save(voucher);
            return voucher.getCode();
        //}
        // return null;
    }

    @Override
    public boolean redeemVoucher(String code) {
        Optional<Voucher> vc = voucherRepository.findById(code);
        if (vc.isPresent()) {
            LOGGER.info("find voucher with code" + code);
            Voucher voucher = vc.get();
            // Promotion promotion = voucher.getPromotion();
            if (validateVoucher(voucher)) {
                int currentApplied = voucher.getCurrentApplied();
                voucher.setCurrentApplied(currentApplied + 1);
                voucher.setUpdatedTime(LocalDateTime.now());
                voucher.setStatus(VoucherStatus.REDEEMED);
                return true;
            }
        } else {
            throw new VoucherNotFoundException(code);
        }
        return false;
    }

    private boolean validateVoucher(
            Voucher voucher
            // ,Order order
            //,Promotion promotion
    ) {

        if (!checkVoucherTimeRange(voucher.getConditions())) {
            throw new VoucherAlreadyExpiredException(voucher.getCode());
        }
        switch (voucher.getRedemptionType()) {
            case SINGLE_REDEMPTION:
                if (voucher.getCurrentApplied() > 0 || VoucherStatus.REDEEMED.equals(voucher.getStatus())) {
                    throw new VoucherAlreadyAppliedException(voucher.getCode());
                }
                break;
            case X_TIMES_REDEMPTION:
                Optional<Condition> condition = voucher.getConditions().stream().filter(cd -> (
                        ConditionType.LIMITED_TIME.equals(cd.getConditionType()))
                ).findFirst();
                if (condition.isPresent() && condition.get().getValue() <= voucher.getCurrentApplied()) {
                    throw new VoucherOutOfUsedException(voucher.getCode());
                }
        }

        return true;
    }

    private boolean checkVoucherTimeRange(Set<Condition> conditionList) {
        for (Condition condition : conditionList) {
            if (ConditionType.DATE_RANGE.equals(condition.getConditionType())) {
                long currentTime = new Date().getTime() / 1000;
                if (ConditionOperator.GREATER.equals(condition.getOperator())
                        && condition.getValue() > currentTime) {
                    return false;
                } else if (ConditionOperator.SMALLER.equals(condition.getOperator())
                        && condition.getValue() < currentTime) {
                    return false;
                }
            }
        }
        return true;
    }

    public Iterable<Voucher>  getAllVouchers(){
        return voucherRepository.findAll();
    }

}
