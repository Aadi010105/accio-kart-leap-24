package com.example.accio_kart_service.service.transformer;

import com.example.accio_kart_service.dto.response.OrderResponse;
import com.example.accio_kart_service.model.OrderEntity;
import org.hibernate.query.Order;

public class OrderTransformer {

    public static OrderResponse prepareOrderResponse(OrderEntity orderEntity){
        return OrderResponse.builder()
                .orderId(orderEntity.getOrderId())
                .numberOfItems(orderEntity.getNumberOfItems())
                .created(orderEntity.getCreated())
                .totalValue(orderEntity.getTotalValue())
                .build();
    }
}
