package com.example.accio_kart_service.controller;

import com.example.accio_kart_service.Enum.Gender;
import com.example.accio_kart_service.model.Customer;
import com.example.accio_kart_service.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

//    @Autowired
//    CustomerService customerService;

    public final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping("/add")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @GetMapping("/get/id/{id}")
    public Customer getCustomer(@PathVariable("id") int customerId){
        return customerService.getCustomer(customerId);
    }

    @GetMapping("/get-all")
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @GetMapping("/get/email/{email}")
    public Customer getCustomerByEmail(@PathVariable("email") String emailId){
        return customerService.getCustomerByEmail(emailId);
    }

    //give all the customer of a particular gender and age-->all males of AGE 25
    @GetMapping("/get-by-gender-age")
    public List<Customer> getAllByGenderAndAge(@RequestParam("gender") Gender gender,
                                               @RequestParam("age") int age){
        return customerService.getAllByGenderAndAge(gender,age);
    }
}
