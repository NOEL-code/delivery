package org.example.store.product;

import jakarta.validation.Valid;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
@Slf4j
public class ProductRestController {

    @Autowired
    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<?> getProduct(@PathVariable(value = "id") Long id){
        log.info("Get product by id: {}", id);
        Product product = productService.findById(id);

        if (product != null) {
            return ResponseEntity.ok(product); // Return 200 OK with the product
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found"); // Return 404 Not Found
        }
    }

    @GetMapping("/products")
    public List<Product> getProductsA(@RequestParam(value = "currentPage") int currentPage, @RequestParam(value = "limit") int limit, @RequestParam(value = "categoryId") int categoryId) {
        return productService.findByCategory(currentPage, limit, categoryId);
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAllProducts() {
        List<Product> products = productService.findAll();
        if (products.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(products);
        } else {
            return ResponseEntity.ok(products);
        }
    }

    @PostMapping("/products")
    public ResponseEntity<?> createProduct(@Valid @RequestBody Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        return ResponseEntity.ok(productService.save(product));
    }



}
