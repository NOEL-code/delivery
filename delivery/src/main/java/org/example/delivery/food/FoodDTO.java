package org.example.delivery.food;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FoodDTO {
    String name;
    int id;
    int price;
    String description;
    String imageURL;

    FoodDTO(Food food) {
        this.name = food.getName();
        this.id = food.getId();
        this.price = food.getPrice();
        this.description = food.getDescription();
        this.imageURL = food.getImageURL();
    }
}
