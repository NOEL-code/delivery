package org.example.store.product;

import lombok.RequiredArgsConstructor;
import org.example.store.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductRestController {

    private final ProductService productService;

    @PostMapping("/new")
    public ResponseEntity<String> create(@RequestBody Product product) {
        productService.save(product);
        return new ResponseEntity<>("Product created successfully", HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Product>> list() {
        List<Product> items = productService.findItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<Product> getItem(@PathVariable("itemId") Long itemId) {
        Product product = productService.findOne(itemId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/{itemId}/edit")
    public ResponseEntity<String> updateItem(@PathVariable Long itemId, @ModelAttribute("form") Product product) {
        productService.updateItem(itemId, product.getName(), product.getPrice(), product.getStockQuantity());
        return new ResponseEntity<>("Product updated successfully", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteItem(@PathVariable Long itemId) {
        productService.delete(itemId);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
