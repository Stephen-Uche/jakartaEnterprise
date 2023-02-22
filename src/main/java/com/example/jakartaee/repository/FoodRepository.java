package com.example.jakartaee.repository;


import com.example.jakartaee.entity.Food;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class FoodRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Food> findAll(){
        var query = entityManager.createQuery("select f from Food f");
        return (List<Food>) query.getResultList();
    }

    public Optional<Food> findOne(Long id){
        return Optional.ofNullable(entityManager.find(Food.class, id));
    }

    public void insertFood(Food food){
        entityManager.persist(food);
    }

    public void deleteFood(Long id){
        var food = findOne(id);
        food.ifPresent((f)-> entityManager.remove(f));
    }







}
