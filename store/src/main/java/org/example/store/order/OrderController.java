package org.example.store.order;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.store.product.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        orderService.save(order);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PostMapping("/{orderId}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long orderId, @RequestBody Order order) {
        order.setId(orderId);
        orderService.save(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable Long orderId) {
        Order order = orderService.findById(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Order> deleteOrder(@PathVariable Long orderId) {
        orderService.delete(orderId);
        return new ResponseEntity<>(orderService.findById(orderId), HttpStatus.OK);
    }

}