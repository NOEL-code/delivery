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

    private final ProductRepository productRepository;

    @Transactional
    public void save(Product product) {
        productRepository.save(product);
    }

    @Transactional
    public void updateItem(Long itemId, String name, int price, int stockQuantity) {
        Product product = productRepository.findById(itemId)
            .orElseThrow(() -> new ProductNotFoundException("Product not found"));
        product.setName(name);
        product.setPrice(price);
        product.setStockQuantity(stockQuantity);
        productRepository.save(product);
    }

    public List<Product> findItems() {
        return productRepository.findAll();
    }

    public Product findOne(Long itemId) {
        return productRepository.findById(itemId)
            .orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }

    @Transactional
    public void delete(Long itemId) {
        productRepository.delete(itemId);
    }
}
