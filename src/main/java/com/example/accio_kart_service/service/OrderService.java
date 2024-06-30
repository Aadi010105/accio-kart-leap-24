package com.example.accio_kart_service.service;

import com.example.accio_kart_service.Enum.ProductStatus;
import com.example.accio_kart_service.dto.response.OrderResponse;
import com.example.accio_kart_service.exception.CustomerNotFoundException;
import com.example.accio_kart_service.exception.ProductNotFoundException;
import com.example.accio_kart_service.model.Coupon;
import com.example.accio_kart_service.model.Customer;
import com.example.accio_kart_service.model.OrderEntity;
import com.example.accio_kart_service.model.Product;
import com.example.accio_kart_service.repository.CouponRepo;
import com.example.accio_kart_service.repository.CustomerRepository;
import com.example.accio_kart_service.repository.ProductRepo;
import com.example.accio_kart_service.service.transformer.OrderTransformer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final CustomerRepository customerRepository;
    private final ProductRepo productRepo;
    private final CouponRepo couponRepo;

    public OrderResponse placeOrder(Map<String, Object> paramsMap) {
        String emailId = (String) paramsMap.get("customer-email");
        int productId = Integer.parseInt((String)paramsMap.get("product-id"));
        int quantityRequired = Integer.parseInt((String) paramsMap.get("quantity"));

        // steps -> validation
        Optional<Customer> customerOptional = customerRepository.findByEmailId(emailId);
        if(customerOptional.isEmpty()){
            throw new CustomerNotFoundException("Invalid email id");
        }

        Optional<Product> optionalProduct = productRepo.findById(productId);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Invalid product id");
        }
        Product product = optionalProduct.get();
        if(product.getQuantityAvailable() < quantityRequired){
            throw new ProductNotFoundException("Insufficient quantity");
        }

        Customer customer = customerOptional.get();
        double totalValue = quantityRequired*product.getPrice();
        totalValue = applyDiscount(customer,totalValue);
        OrderEntity orderEntity = OrderEntity.builder()
                .orderId(String.valueOf(UUID.randomUUID()))
                .numberOfItems(quantityRequired)
                .totalValue(totalValue)
                .build();

        customer.getOrders().add(orderEntity);
        // update product inventory
        product.setQuantityAvailable(product.getQuantityAvailable()-quantityRequired);
        if(product.getQuantityAvailable()==0){
            product.setProductStatus(ProductStatus.OUT_OF_STOCK);
        }

        Customer savedCustomer = customerRepository.save(customer); // customer and order
        productRepo.save(product); // product

        // preapre response dto -> orderresponse
        OrderEntity latestOrder = savedCustomer.getOrders().get(customer.getOrders().size()-1);
        return OrderTransformer.prepareOrderResponse(latestOrder);
    }

    private double applyDiscount(Customer customer, double totalValue) {
        Optional<Coupon> optionalCoupon = couponRepo.getRandomCoupon(customer);
        if(optionalCoupon.isPresent()){
            Coupon coupon = optionalCoupon.get();
            log.info("coupon applied"+coupon.getCouponCode());
            totalValue -= (totalValue*coupon.getPercentageDiscount())/100.0;
        }
        return totalValue;
    }

}
