package org.example.delivery.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {

    @Autowired
    FoodService foodService;
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/foods/{id}")
    public FoodDTO findFood(@PathVariable int id){
        return foodService.findFood(id);
    }
}
