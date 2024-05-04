package org.example.delivery.food;

import java.util.HashMap;
import org.springframework.stereotype.Repository;

@Repository
public class FoodRepository {

    HashMap<Integer, Food> foodTable = new HashMap<>();

    public FoodDTO findById(int id) {
        return new FoodDTO(foodTable.get(id));
    }
}
