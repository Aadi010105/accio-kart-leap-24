package com.example.accio_kart_service.repository;

import com.example.accio_kart_service.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.crypto.spec.OAEPParameterSpec;
import javax.swing.text.html.Option;
import java.util.Optional;

public interface CouponRepo extends JpaRepository<Coupon,Integer> {

    Optional<Coupon>  findByCouponCode(String couponCode);
}
