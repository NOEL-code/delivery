package org.example.store.order;

import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.example.store.exception.OrderNotFoundException;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class OrderRepository {

    private EntityManager em;

    public Optional<Order> findById(Long id) {
        return Optional.ofNullable(em.find(Order.class, id));
    }

    public List<Order> findAll() {
        List<Order> orders = em.createQuery("select o from Order o", Order.class).getResultList();
        if (orders.isEmpty()) {
            throw new OrderNotFoundException("No orders found");
        } else {
            return orders;
        }
    }

    public Order save(Order order) {
        if (em.find(Order.class, order.getId()) == null) {
            em.persist(order);
        } else {
            em.merge(order);
        }
        return order;
    }

    public void delete(Long id) {
        Order order = findById(id).orElseThrow(() -> new OrderNotFoundException("Order not found"));
        em.remove(order);
    }
}