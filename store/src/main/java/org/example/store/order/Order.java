package org.example.store.order;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.example.store.member.Member;
import org.example.store.product.Product;

@Getter
@Setter
//@RequiredArgsConstructor
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product; // Domain = Object

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    private int quantity;

    public Order(Product orderdProduct, int quantity) {
        this.product = orderdProduct;
        this.quantity = quantity;
    }
    // DB column : Orders orders_id or id "통일성"
}

