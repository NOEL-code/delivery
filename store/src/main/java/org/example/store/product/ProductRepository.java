package org.example.store.product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.store.exception.ProductNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductRepository {

    private final EntityManager em;

    public void save(Product product) {
        if (product.getName() == null) {
            em.persist(product);
        } else {
            em.merge(product);
        }
    }

    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(em.find(Product.class, id));
    }

    public List<Product> findAll() {
        List<Product> products = em.createQuery("select p from Product p", Product.class).getResultList();
        if (products.isEmpty()) {
            throw new ProductNotFoundException("No products found");
        }
        return products;
    }

    public void delete(Long id) {
        Product product = findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
        em.remove(product);
    }
}
