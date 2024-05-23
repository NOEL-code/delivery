package org.example.store.order;

import jakarta.transaction.Transactional;
import java.util.List;
import lombok.AllArgsConstructor;
import org.example.store.exception.OrderNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {

    OrderRepository orderRepository;

    public Order findById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Transactional
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Transactional
    public void delete(Long id) {
        orderRepository.delete(id);
    }

    @Transactional
    public void update(Order order) {
        orderRepository.findById(order.getId()).orElseThrow(() -> new OrderNotFoundException("Order not Found"));
        orderRepository.save(order);
    }


}
