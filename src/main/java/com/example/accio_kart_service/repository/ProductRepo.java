package com.example.accio_kart_service.repository;

import com.example.accio_kart_service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
