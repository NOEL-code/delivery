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
    public ResponseEntity<String> create(@RequestBody RegisterProductDto registerProductDto) {
        Product product = registerProductDto.toEntity(registerProductDto.getName(), registerProductDto.getPrice(),
            registerProductDto.getStockQuantity());
        productService.save(product);
        return new ResponseEntity<>("제품이 성공적으로 생성되었습니다.", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> list() {
        List<Product> items = productService.findItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<Product> getItem(@PathVariable("itemId") Long itemId) {
        Product product = productService.findOne(itemId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping("/{itemId}/edit")
    public ResponseEntity<String> updateItem(@PathVariable("itemId") Long itemId, @RequestBody RegisterProductDto updateProductDto) {
        productService.updateItem(itemId, updateProductDto.getName(), updateProductDto.getPrice(), updateProductDto.getStockQuantity());
        return new ResponseEntity<>("제품이 성공적으로 업데이트되었습니다.", HttpStatus.OK);
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<String> deleteItem(@PathVariable("itemId") Long itemId) {
        productService.delete(itemId);
        return new ResponseEntity<>("제품이 성공적으로 삭제되었습니다.", HttpStatus.OK);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
