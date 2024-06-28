package com.example.accio_kart_service.controller;

import com.example.accio_kart_service.dto.request.ProductRequest;
import com.example.accio_kart_service.model.Product;
import com.example.accio_kart_service.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product addProduct(@RequestParam("s_id") String uniqueSellerNumber
            ,@RequestBody ProductRequest productRequest){
        return productService.addProduct(uniqueSellerNumber,productRequest);
    }


}
