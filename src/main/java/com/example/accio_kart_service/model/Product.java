package com.example.accio_kart_service.model;

import com.example.accio_kart_service.Enum.ProductStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String productName;

    double price;

    int quantityAvailable;

    @Enumerated(EnumType.STRING)
    ProductStatus productStatus;

    String description;

    @ManyToOne
    @JoinColumn(name="seller_id")
    @JsonIgnore
    Seller seller;
}
