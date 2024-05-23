package org.example.store.order;

import lombok.AllArgsConstructor;
import org.example.store.product.Product;
import org.example.store.product.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {
    OrderService orderService;
    ProductService productService;


    @PostMapping("/new")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {

    }
//    @PostMapping("/orders")
//    public void orderProduct(@RequestBody OrderDTO orderDto) {
//        Product orderdProduct = productService.findProduct(orderDto.getProductId());
//
//        // TODO : Service로 이사 갈거에요. DTO -> Entity
//        Order requestOrder = new Order(
//            orderdProduct, orderDto.getCount()
//        );
//      requestOrder.setId();
//        requestOrder.setProduct(orderdProduct);
//        requestOrder.setCount(orderDto.getCount());
//
//        orderService.orderProduct(requestOrder);
//    }
}