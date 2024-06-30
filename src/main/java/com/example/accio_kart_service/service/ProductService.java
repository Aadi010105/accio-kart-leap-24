package com.example.accio_kart_service.service;

import com.example.accio_kart_service.dto.request.ProductRequest;
import com.example.accio_kart_service.exception.SellerNotFoundException;
import com.example.accio_kart_service.model.Product;
import com.example.accio_kart_service.model.Seller;
import com.example.accio_kart_service.repository.SellerRepository;
import com.example.accio_kart_service.service.transformer.ProductTransformer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final SellerRepository sellerRepository;

    public ProductService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public Product addProduct(String sellerUniqueNumber,
                              ProductRequest productRequest) {

        Optional<Seller> optionalSeller = sellerRepository.findByUniqueSellerNumber(sellerUniqueNumber);
        if(optionalSeller.isEmpty()){
            throw new SellerNotFoundException("Invalid seller number!!!");
        }

        Seller seller = optionalSeller.get();

        Product product = ProductTransformer.productRequestToProduct(productRequest);

        // setting both them
        product.setSeller(seller);
        seller.getProducts().add(product);

        Seller savedSeller = sellerRepository.save(seller);
        return savedSeller.getProducts().get(savedSeller.getProducts().size()-1);

    }

}
