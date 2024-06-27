package com.example.accio_kart_service.service.transformer;

import com.example.accio_kart_service.dto.request.CustomerRequest;
import com.example.accio_kart_service.dto.response.CustomerResponse;
import com.example.accio_kart_service.model.Customer;

public class CustomerTransformer {

    public static Customer customerRequestToCustomer(CustomerRequest customerRequest){
//        Customer customer = new Customer();
//        customer.setName(customerRequest.getName());
//        customer.setEmailId(customerRequest.getEmailId());
//        customer.setCity(customerRequest.getCity());   //iski jagah use karenge hum builder
//        customer.setAge(customerRequest.getAge());
//        customer.setGender(customerRequest.getGender());
//        return customer;
         return Customer.builder()
                .age(customerRequest.getAge())
                .name(customerRequest.getName())
                .city(customerRequest.getCity())
                .emailId(customerRequest.getEmailId())
                .gender(customerRequest.getGender())
                .build();
    }

    public static CustomerResponse customerToCustomerResponse(Customer customer){
//        CustomerResponse customerResponse = new CustomerResponse();
//        customerResponse.setName(customer.getName());
//        customerResponse.setEmailId(customer.getEmailId());
//        customerResponse.setCreated(customer.getCreated());
//        return customerResponse;

        return CustomerResponse.builder()
                .name(customer.getName())
                .created(customer.getCreated())
                .emailId(customer.getEmailId())
                .build();

    }
}
