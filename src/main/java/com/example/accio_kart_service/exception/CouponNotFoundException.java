package com.example.accio_kart_service.exception;

public class CouponNotFoundException extends RuntimeException{

    public CouponNotFoundException(String message) {
        super(message);
    }
}
