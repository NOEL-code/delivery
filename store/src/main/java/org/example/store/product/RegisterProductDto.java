package org.example.store.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.springframework.http.ResponseEntity;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterProductDto {

    @NotBlank(message = "product name is null")
    private String name;

    @Range(min = 0, max = 99999999, message = "product price range is 0 ~ 99999999")
    private int price;

    @NotNull(message = "stock quantity is null")
    private int stockQuantity;

    public Product toEntity(String name, int price, int stockQuantity){
        return new Product(name, price, stockQuantity);
    }
}
