package com.example.accio_kart_service.model;


import com.example.accio_kart_service.Enum.IdentityType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "unique_identity")
public class Identity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;


    @Enumerated(EnumType.STRING)
    IdentityType identityType;

    String identityNumber;
}
