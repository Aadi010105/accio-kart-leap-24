package com.example.accio_kart_service.repository;

import com.example.accio_kart_service.Enum.Gender;
import com.example.accio_kart_service.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

   Optional<Customer> findByEmailId(String emailId);

   List<Customer> findByGenderAndAge(Gender gender,int age);

   @Query("select count(c) from Customer c where c.age > :age")
   int getCountOfAgeGreaterThan(@Param("age") int age);

   @Query("select count(c) from Customer c where c.gender = :g")
   int getCountOfGender(@Param("g") Gender gender);


//   @Query(value = "select count(*) from customer where gender = :g", nativeQuery = true)
//   int getCountOfGender(@Param("g") String gender);   //As A SQL QUERY--->>But CONFUSIONSSS


}
