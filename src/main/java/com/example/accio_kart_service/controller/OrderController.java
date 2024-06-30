package com.example.accio_kart_service.controller;

import com.example.accio_kart_service.dto.response.OrderResponse;
import com.example.accio_kart_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> placeOrder(@RequestParam("product-id") int productId,
                                                    @RequestParam("quantity") int quantity,
                                                    @RequestParam("customer-email")String customerEmail,
                                                    @RequestParam Map<String,Object> paramsMap){

        OrderResponse orderResponse = orderService.placeOrder(paramsMap);
        return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
    }
}
