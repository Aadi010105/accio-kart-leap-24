package com.example.accio_kart_service.repository;

import com.example.accio_kart_service.model.Coupon;
import com.example.accio_kart_service.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.crypto.spec.OAEPParameterSpec;
import javax.swing.text.html.Option;
import java.util.Optional;

public interface CouponRepo extends JpaRepository<Coupon,Integer> {

    Optional<Coupon>  findByCouponCode(String couponCode);

    @Query("Select c from Coupon c where :customer IN c.customers " + "order by random() limit 1" )

    Optional<Coupon> getRandomCoupon(Customer customer);
}
