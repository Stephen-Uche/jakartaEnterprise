package com.example.jakartaee.controller;

import com.example.jakartaee.entity.Food;
import com.example.jakartaee.repository.FoodRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

@Path("/foods")
public class FoodController {

    @Inject
    FoodRepository repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Food> getAll(){
        return repository.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOne(@PathParam("id") Long id){
        var food = repository.findOne(id);
        if( food.isPresent())
            return Response.ok().entity(food.get()).build();
        return Response.status(404).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addOne(Food food){
        //Validation
        repository.insertFood(food);
        return Response.created(URI.create("foods/" + food.getId())).build();
    }

}
