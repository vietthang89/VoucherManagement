package com.justintu.services;


import com.justintu.api.exception.VoucherAlreadyAppliedException;
import com.justintu.api.exception.VoucherAlreadyExpiredException;
import com.justintu.api.exception.VoucherOutOfUsedException;
import com.justintu.constants.RedemptionType;
import com.justintu.constants.VoucherStatus;
import com.justintu.constants.VoucherType;
import com.justintu.domain.Condition;
import com.justintu.domain.Promotion;
import com.justintu.domain.Voucher;
import com.justintu.domain.factory.ConditionFactory;
import com.justintu.dto.ConditionDTO;
import com.justintu.dto.VoucherDTO;
import com.justintu.mapper.ConditionMapper;
import com.justintu.repositories.PromotionRepository;
import com.justintu.repositories.VoucherRepository;
import com.justintu.services.impl.VoucherServiceImpl;
import com.justintu.utils.VoucherCodeGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Set;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class VoucherServiceTest {

    @Mock
    VoucherRepository voucherRepository;

    @Mock
    PromotionRepository promotionRepository;

    @InjectMocks
    VoucherServiceImpl voucherServiceImpl;

    @Test
    public void should_be_able_to_create_limited_voucher() {
        Condition condition = ConditionFactory.createLimitedTimeCondition(5);
        ConditionDTO conditionDTO = ConditionMapper.toDTO(condition);
        VoucherDTO dto = new VoucherDTO("Free", "another voucher", RedemptionType.X_TIMES_REDEMPTION, Collections.singleton(conditionDTO));
        String code = voucherServiceImpl.generateVoucher(dto);

        Assert.assertNotNull(code);
    }

    @Test
    public void should_be_able_to_redeem_today() {
        LocalDateTime today = LocalDateTime.now();
        Voucher voucher = new Voucher();
        voucher.setCode("ABC123");
        voucher.setName("Free voucher");
        voucher.setRedemptionType(RedemptionType.TIME_REDEMPTION);
        voucher.setStatus(VoucherStatus.NEW);
        voucher.setConditions(ConditionFactory.createDateRangeConditions(today, today.plusDays(7)));
        voucherRepository.save(voucher);
        when(voucherRepository.findById("ABC123")).thenReturn(java.util.Optional.of(voucher));

        boolean result = voucherServiceImpl.redeemVoucher("ABC123");
        Assert.assertEquals(result, true);
    }

    @Test(expected = VoucherAlreadyAppliedException.class)
    public void should_not_redeem_used_single_redemption_voucher() {
        Voucher voucher = new Voucher();
        voucher.setCode("ABC123");
        voucher.setName("Free voucher");
        voucher.setRedemptionType(RedemptionType.SINGLE_REDEMPTION);
        voucher.setStatus(VoucherStatus.REDEEMED);
        voucher.setCurrentApplied(1);
        voucherRepository.save(voucher);

        when(voucherRepository.findById("ABC123")).thenReturn(java.util.Optional.of(voucher));
        voucherServiceImpl.redeemVoucher("ABC123");
    }


    @Test(expected = VoucherAlreadyExpiredException.class)
    public void should_not_redeem_expired_voucher() {
        LocalDateTime today = LocalDateTime.now();
        Voucher voucher = new Voucher();
        voucher.setCode("ABC123");
        voucher.setName("Free voucher");
        voucher.setRedemptionType(RedemptionType.SINGLE_REDEMPTION);
        voucher.setStatus(VoucherStatus.EXPIRED);
        voucher.setCurrentApplied(1);
        voucher.setConditions(ConditionFactory.createDateRangeConditions(today.minusDays(20), today.minusDays(10)));
        voucherRepository.save(voucher);

        when(voucherRepository.findById("ABC123")).thenReturn(java.util.Optional.of(voucher));
        voucherServiceImpl.redeemVoucher("ABC123");
    }

    @Test()
    public void should_be_able_to_redeem_many_time() {
        Voucher voucher = new Voucher();
        voucher.setCode("ABC123");
        voucher.setName("Free voucher");
        voucher.setRedemptionType(RedemptionType.MULTIPLE_REDEMPTION);
        voucher.setStatus(VoucherStatus.REDEEMED);
        voucher.setCurrentApplied(1);
        voucherRepository.save(voucher);

        when(voucherRepository.findById("ABC123")).thenReturn(java.util.Optional.of(voucher));
        for (int i = 0; i < 10; i++) {
            voucherServiceImpl.redeemVoucher("ABC123");
        }
    }

    @Test(expected = VoucherOutOfUsedException.class)
    public void should_not_be_able_to_redeem_more_than_limited_time() {
        Voucher voucher = new Voucher();
        voucher.setCode("ABC123");
        voucher.setName("Free voucher");
        voucher.setRedemptionType(RedemptionType.X_TIMES_REDEMPTION);
        voucher.setStatus(VoucherStatus.REDEEMED);
        voucher.setConditions(ConditionFactory.createLimitedTimeConditions(5));
        voucher.setCurrentApplied(5);
        voucherRepository.save(voucher);

        when(voucherRepository.findById("ABC123")).thenReturn(java.util.Optional.of(voucher));
        voucherServiceImpl.redeemVoucher("ABC123");
    }


}
