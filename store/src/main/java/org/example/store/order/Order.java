package org.example.store.order;


import lombok.Getter;
import lombok.Setter;
import org.example.store.product.Product;

@Getter
@Setter
//@RequiredArgsConstructor
public class Order {
    int id;
    Product product; // Domain = Object
    int count;

    public Order(Product orderdProduct, int count) {
        this.product = orderdProduct;
        this.count = count;
    }
    // DB column : Orders orders_id or id "통일성"
}

