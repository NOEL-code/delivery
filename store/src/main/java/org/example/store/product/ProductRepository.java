package org.example.store.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    Long id = 0L;

    HashMap<Long, Product> products = new HashMap<>();

    public Product save(Product product) {
        products.put(id++, product);
        return product;
    }

    public Product findById(Long id) {
        return products.get(id);
    }

    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();
        products.forEach(product -> {
            if (product.getName().equals(name)) {
                products.add(product);
            }
        });
        return products;
    }
}
