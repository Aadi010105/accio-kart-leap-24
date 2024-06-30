package com.example.accio_kart_service.dto.response;

import com.example.accio_kart_service.Enum.ProductStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductResponse {

    String productName;

    double price;


    ProductStatus productStatus;

    SellerResponse sellerResponse;
}
