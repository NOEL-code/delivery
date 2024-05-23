package org.example.store.product;

import lombok.RequiredArgsConstructor;
import org.example.store.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {
    private final ProductJPARepository productJpaRepository;

    public Product findOne(Long itemId) {
        return productJpaRepository.findById(itemId)
            .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + itemId));
    }

    public List<Product> findItems() {
        return productJpaRepository.findAll();
    }

    @Transactional
    public void save(Product product) {
        productJpaRepository.save(product);
    }

    @Transactional
    public void updateItem(Long itemId, String name, int price, int stockQuantity) {
        Product product = productJpaRepository.findById(itemId)
            .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + itemId));
        product.setName(name);
        product.setPrice(price);
        product.setStockQuantity(stockQuantity);
        // No need to call save explicitly after setting properties if Product is a managed entity
        // productJpaRepository.save(product);
    }

    @Transactional
    public void delete(Long itemId) {
        if (!productJpaRepository.existsById(itemId)) {
            throw new ProductNotFoundException("Product not found with id: " + itemId);
        }
        productJpaRepository.deleteById(itemId);
    }
}
