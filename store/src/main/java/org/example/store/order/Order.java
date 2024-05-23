package org.example.store.order;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.example.store.product.Product;

@Getter
@Setter
//@RequiredArgsConstructor
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    Long id;

    Product product; // Domain = Object

    int quantity;

    public Order(Product orderdProduct, int quantity) {
        this.product = orderdProduct;
        this.quantity = quantity;
    }
    // DB column : Orders orders_id or id "통일성"
}

