package org.example.delivery.food;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Food {
    String name;
    int id;
    int price;
    String description;
    String imageURL;

    Food(FoodDTO foodDTO){
        this.name = foodDTO.getName();
        this.id = foodDTO.getId();
        this.price = foodDTO.getPrice();
        this.description = foodDTO.getDescription();
        this.imageURL = foodDTO.getImageURL();
    }
}
