package org.example.store.order;

import lombok.RequiredArgsConstructor;
import org.example.store.product.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {
    OrderService orderService;

    ProductService productService;


    @PostMapping("/new")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        
    }

}