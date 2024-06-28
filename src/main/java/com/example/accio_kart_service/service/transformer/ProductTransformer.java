package com.example.accio_kart_service.service.transformer;

import com.example.accio_kart_service.Enum.ProductStatus;
import com.example.accio_kart_service.dto.request.ProductRequest;
import com.example.accio_kart_service.model.Product;
import lombok.Builder;

public class ProductTransformer {

    public static Product productRequestToProduct(ProductRequest productRequest){
        return Product.builder()
                .productName(productRequest.getProductName())
                .price(productRequest.getPrice())
                .quantityAvailable(productRequest.getQuantityAvailable())
                .description(productRequest.getDescription())
                .productStatus(ProductStatus.AVAILABLE)
                .build();
    }




}
