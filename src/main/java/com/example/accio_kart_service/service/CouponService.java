package com.example.accio_kart_service.service;

import com.example.accio_kart_service.model.Coupon;
import com.example.accio_kart_service.repository.CouponRepo;
import org.springframework.stereotype.Service;

@Service
public class CouponService {

    private final CouponRepo couponRepo;

    public CouponService(CouponRepo couponRepo) {
        this.couponRepo = couponRepo;
    }

    public void addCoupon(String couponCode,
                          double percentageDiscount) {
        Coupon coupon = Coupon.builder()
                .couponCode(couponCode)
                .percentageDiscount(percentageDiscount)
                .build();
        couponRepo.save(coupon);
    }
}
