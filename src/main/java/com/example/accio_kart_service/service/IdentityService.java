package com.example.accio_kart_service.service;

import com.example.accio_kart_service.model.Customer;
import com.example.accio_kart_service.model.Identity;
import com.example.accio_kart_service.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class IdentityService {

    public final CustomerService customerService;
    public final CustomerRepository customerRepository;

    public IdentityService(CustomerService customerService,
                           CustomerRepository customerRepository) {
        this.customerService = customerService;
        this.customerRepository = customerRepository;
    }

    public  void addIdentity(Identity identity, String email) {
        Customer customer=customerService.getCustomerByEmail(email);
        customer.setIdentity(identity);

        customerRepository.save(customer);
    }
}
