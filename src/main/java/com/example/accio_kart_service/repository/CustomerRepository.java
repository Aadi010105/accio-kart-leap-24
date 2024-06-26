package com.example.accio_kart_service.repository;

import com.example.accio_kart_service.Enum.Gender;
import com.example.accio_kart_service.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

   Optional<Customer> findByEmailId(String emailId);

   List<Customer> findByGenderAndAge(Gender gender,int age);
}
