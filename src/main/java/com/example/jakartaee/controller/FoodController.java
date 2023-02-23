package com.example.jakartaee.controller;

import com.example.jakartaee.dto.FoodDto;
import com.example.jakartaee.entity.Food;
import com.example.jakartaee.mapper.Mapper;
import com.example.jakartaee.repository.FoodRepository;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

@Path("/foods")
public class FoodController {

    @Inject
    FoodRepository repository;

    @Inject
    Mapper mapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<FoodDto> getAll(@QueryParam("name") String name){
        if( name == null)
            return mapper.map(repository.findAll());

        return mapper.map(repository.findAllByName(name));
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
    public Response addOne(@Valid Food food){
      // if(!validator.validate(food))
      //      return Response.status(400,"name can't be null or empty").build();
        repository.insertFood(food);
        return Response.created(URI.create("foods/" + food.getId())).build();
    }

    @DELETE
    @Path("/{id}")
    public void deleteOne(@PathParam("id") Long id){
        repository.deleteFood(id);
    }


}
