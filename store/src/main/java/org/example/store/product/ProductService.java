package org.example.store.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findByCategory(int categoryId, int currentPage, int limit) {
        return productRepository.findProducts(categoryId, currentPage, limit);
    }

    public Product findById(Long id) {
        Optional<Product> productOptional = Optional.ofNullable(productRepository.findById(id));
        return productOptional.orElse(null); // Return null if product not found
    }


    public Product save(Product product) {
        return productRepository.save(product);
    }

    public List<Product> deleteProducts(Map<String, List<Long>> deleteIds) {
        List<Product> products = new ArrayList<>();

        deleteIds.forEach((key, value) -> {
            value.forEach(id -> {
                Optional<Product> productOptional = Optional.ofNullable(
                    productRepository.findById(id));
                productOptional.ifPresent(product -> {
                    products.add(product);
                    productRepository.deleteProduct(product.getId());
                });
            });
        });

        return products;
    }



    public Product deleteProduct(Long id) {

        Product product = productRepository.findById(id);
        if(product != null) {
            productRepository.deleteProduct(id);
            return product;
        }
        return null;
    }
}
