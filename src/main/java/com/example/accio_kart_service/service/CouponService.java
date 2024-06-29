package com.example.accio_kart_service.service;

import com.example.accio_kart_service.exception.CouponNotFoundException;
import com.example.accio_kart_service.exception.CustomerNotFoundException;
import com.example.accio_kart_service.model.Coupon;
import com.example.accio_kart_service.model.Customer;
import com.example.accio_kart_service.repository.CouponRepo;
import com.example.accio_kart_service.repository.CustomerRepository;
import com.example.accio_kart_service.utils.CustomerValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CouponService {

    private final CouponRepo couponRepo;
    private final CustomerRepository customerRepository;
    private final CustomerValidator customerValidator;


    public void addCoupon(String couponCode,
                          double percentageDiscount) {
        Coupon coupon = Coupon.builder()
                .couponCode(couponCode)
                .percentageDiscount(percentageDiscount)
                .build();
        couponRepo.save(coupon);
    }

    public String assignCoupon(String emailId, String couponCode) {
        if(!customerValidator.isValid(emailId)){
            throw new CustomerNotFoundException("Invalid customer email");
        }

        Optional<Coupon> couponOptional = couponRepo.findByCouponCode(couponCode);
        if(couponOptional.isEmpty()){
            throw new CouponNotFoundException("Invalid coupon code");
        }

        Coupon coupon = couponOptional.get();
        Customer customer = customerRepository.findByEmailId(emailId).get();
        coupon.getCustomers().add(customer);
        couponRepo.save(coupon);

        return "Coupon assigned successfully !!";
    }
}
