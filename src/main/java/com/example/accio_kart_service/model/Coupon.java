package com.example.accio_kart_service.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "coupon")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(unique = true)
    String couponCode;

    double percentageDiscount;

    @ManyToMany
    @JoinTable(name = "customers_coupons" ,
            joinColumns = {@JoinColumn(name = "coupon_id")},
            inverseJoinColumns ={@JoinColumn(name = "customer_id")})
    List<Customer> customers=new ArrayList<>();
}
