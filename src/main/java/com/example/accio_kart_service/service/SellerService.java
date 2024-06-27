package com.example.accio_kart_service.service;

import com.example.accio_kart_service.dto.request.SellerRequest;
import com.example.accio_kart_service.dto.response.SellerResponse;
import com.example.accio_kart_service.model.Seller;
import com.example.accio_kart_service.repository.SellerRepository;
import com.example.accio_kart_service.service.transformer.SellerTransformer;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    private final SellerRepository sellerRepository;

    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public SellerResponse addSeller(SellerRequest sellerRequest) {
        Seller seller= SellerTransformer.sellerRequestToSeller(sellerRequest);
        Seller savedSeller= sellerRepository.save(seller);
        return SellerTransformer.sellerToSellerResponse(savedSeller);
    }
}
