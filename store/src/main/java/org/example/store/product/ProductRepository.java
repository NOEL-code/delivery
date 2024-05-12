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

        product.setId(++id);

        products.put(product.getId(), product);
        return product;
    }

    public Product findById(Long id) {
        return products.get(id);
    }

    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    public List<Product> findProducts(int categoryId, int currentPage, int limit) {
        List<Product> returnProducts = new ArrayList<>();
        int count = 0;

        for (Product product : products.values()) {

            if (product.getCategoryID() != categoryId) {
                continue;
            }

            if (count++ >= (currentPage - 1) * limit) {
                returnProducts.add(product);
            }

            if (count >= currentPage * limit) {
                break;
            }
        }
        return returnProducts;
    }

    public void deleteProduct(Long id) {
        products.remove(id);
    }
}
