package com.example.jakartaee.mapper;

import com.example.jakartaee.dto.FoodDto;
import com.example.jakartaee.entity.Food;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class Mapper {

    public List<FoodDto> map(List<Food> all) {
        return all.stream().map(food-> new FoodDto(food.getId(), food.getName())).toList();
    }
}
