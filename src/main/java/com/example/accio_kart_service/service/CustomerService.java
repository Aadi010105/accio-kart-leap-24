package com.example.accio_kart_service.service;

import com.example.accio_kart_service.Enum.Gender;
import com.example.accio_kart_service.dto.request.CustomerRequest;
import com.example.accio_kart_service.dto.response.CustomerResponse;
import com.example.accio_kart_service.exception.CustomerNotFoundException;
import com.example.accio_kart_service.model.Customer;
import com.example.accio_kart_service.repository.CustomerRepository;
import com.example.accio_kart_service.service.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        //request dto-->entity conversion
        Customer customer= CustomerTransformer.customerRequestToCustomer(customerRequest);

        Customer savedCustomer = customerRepository.save(customer); //returns save customer

        return CustomerTransformer.customerToCustomerResponse(savedCustomer);
        //saved Entity --->> response Dto

    }


    public CustomerResponse getCustomer(int customerId) {
        Optional<Customer> optionalCustomer= customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Invalid CustomerId");
        }

        return CustomerTransformer.customerToCustomerResponse(optionalCustomer.get());

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

    public List<CustomerResponse> getAllByGenderAndAge(Gender gender, int age) {
        List<Customer> customers= customerRepository.findByGenderAndAge(gender, age);
        List<CustomerResponse> customerResponses= new ArrayList<>();
        for(Customer customer: customers){
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponses;
    }

    public int getCountOfAgeGreaterThan(int age) {
        return customerRepository.getCountOfAgeGreaterThan(age);
    }

    public int getCountOfGender(Gender gender) {
        return customerRepository.getCountOfGender(gender);
    }
}
