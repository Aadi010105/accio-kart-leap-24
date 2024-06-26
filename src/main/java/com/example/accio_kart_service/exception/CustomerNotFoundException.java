package com.example.accio_kart_service.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String message){
        super (message);
    }
}
