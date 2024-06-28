package com.example.accio_kart_service.repository;

import com.example.accio_kart_service.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepo extends JpaRepository<Coupon,Integer> {
}
