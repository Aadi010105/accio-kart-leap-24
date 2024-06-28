package com.example.accio_kart_service.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductRequest {

    String productName;

    double price;

    int quantityAvailable;

    String description;
}
