package com.example.accio_kart_service.repository;

import com.example.accio_kart_service.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerRepository extends JpaRepository<Seller,Integer> {

    Optional<Seller> findByUniqueSellerNumber(String uniqueSellerNumber);
}
