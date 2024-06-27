package com.example.accio_kart_service.service.transformer;

import com.example.accio_kart_service.dto.request.SellerRequest;
import com.example.accio_kart_service.dto.response.SellerResponse;
import com.example.accio_kart_service.model.Seller;

import java.util.UUID;

public class SellerTransformer {

    public static Seller sellerRequestToSeller(SellerRequest sellerRequest){
        return Seller.builder()
                .uniqueSellerNumber(String.valueOf(UUID.randomUUID()))
                .name(sellerRequest.getName())
                .age(sellerRequest.getAge())
                .mobileNumber(sellerRequest.getMobileNumber())
                .build();
    }

    public static SellerResponse sellerToSellerResponse(Seller seller){
        return SellerResponse.builder()
                .uniqueSellerNumber(seller.getUniqueSellerNumber())
                .name(seller.getName())
                .build();
    }
}
