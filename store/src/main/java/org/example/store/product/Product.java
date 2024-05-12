package org.example.store.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    private Long id;

    @NotBlank
    private String name;

    private int categoryID;

    @NotBlank
    private String description;

    private String summary;

    @Positive
    private int price;

    Product(ProductDto productDto){

        this.id = productDto.getId();
        this.categoryID = productDto.getCategoryID();
        this.name = productDto.getName();
        this.description = productDto.getDescription();
        this.summary = productDto.getDescription();
        this.price = productDto.getPrice();
    }
}
