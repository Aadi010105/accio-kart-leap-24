package com.example.accio_kart_service.service;

import com.example.accio_kart_service.model.Customer;
import com.example.accio_kart_service.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer) {
         Customer savedCustomer= customerRepository.save(customer);
         return savedCustomer;
    }
}
