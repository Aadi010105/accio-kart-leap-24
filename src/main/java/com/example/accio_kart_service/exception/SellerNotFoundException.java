package com.example.accio_kart_service.exception;

public class SellerNotFoundException extends RuntimeException{

    public SellerNotFoundException(String message) {
        super(message);
    }
}
