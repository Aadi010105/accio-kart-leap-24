package com.example.accio_kart_service.utils;

import com.example.accio_kart_service.exception.CustomerNotFoundException;
import com.example.accio_kart_service.model.Customer;
import com.example.accio_kart_service.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class CustomerValidator {

    private final CustomerRepository customerRepository;

    public boolean isValid(String email){
        Optional<Customer> optionalCustomer = customerRepository.findByEmailId(email);
        System.out.println(optionalCustomer.get().getName());
        return optionalCustomer.isPresent();
    }
}
