package com.example.jakartaee.dto;

public class FoodDto {
    private Long id;
    private String dishName;

    public FoodDto() {
    }

    public FoodDto(Long id, String dishName) {
        this.id = id;
        this.dishName = dishName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }
}
