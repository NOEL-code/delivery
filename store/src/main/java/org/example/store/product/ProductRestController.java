package org.example.store.product;

import java.util.List;
import java.util.regex.Pattern;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/proudcts")
@Slf4j
public class ProductRestController {

    @Autowired
    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("path = {id}")
    public Product getProduct(@RequestParam(value="id") Long id){
        return productService.findById(id);
    }

    @GetMapping()
    public List<Product> getProducts(@RequestParam(value = "currentPage") int currentPage, @RequestParam(value = "limit") int limit, @RequestParam(value = "categoryId") int categoryId) {
        return productService.findAll(currentPage, categoryId, limit);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        Pattern.matches()
        return productService.save(product);
    }

}
