package com.example.accio_kart_service.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SellerResponse {

    String name;

    String uniqueSellerNumber;
}
