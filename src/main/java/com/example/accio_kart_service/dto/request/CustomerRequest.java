package com.example.accio_kart_service.dto.request;

import com.example.accio_kart_service.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;


@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerRequest {

    String name;

    String emailId;

    int age;

    Gender gender;

    String city;

}
