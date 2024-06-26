package com.example.accio_kart_service.service;

import com.example.accio_kart_service.Enum.Gender;
import com.example.accio_kart_service.exception.CustomerNotFoundException;
import com.example.accio_kart_service.model.Customer;
import com.example.accio_kart_service.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }


    public Customer getCustomer(int customerId) {
        Optional<Customer> optionalCustomer= customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Invalid CustomerId");
        }

        return optionalCustomer.get();
    }


    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public Customer getCustomerByEmail(String emailId) {
        Optional<Customer> optionalCustomer=customerRepository.findByEmailId(emailId);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Invalid EmailId");
        }

        return optionalCustomer.get();
    }

    public List<Customer> getAllByGenderAndAge(Gender gender, int age) {
        return customerRepository.findByGenderAndAge(gender, age);
    }
}
