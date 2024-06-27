package com.example.accio_kart_service.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SellerRequest {

    String name;

    String mobileNumber;

    int age;

}
