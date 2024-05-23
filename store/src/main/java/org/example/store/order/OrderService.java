package org.example.store.order;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {

    OrderRepository orderRepository;

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public Order findById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public void delete(Long id) {
        orderRepository.delete(id);
    }

    public void update(Order order) {
        orderRepository.findById(order.getId());

        orderRepository.save(order);
    }


}
