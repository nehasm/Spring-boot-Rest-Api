package com.food.city.mapper;

import com.food.city.controller.RestaurantsController;
import com.food.city.model.Restaurant;

import com.food.city.dto.RestaurantRepresentation;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class RestaurantModelMapper implements RepresentationModelAssembler<Restaurant, RestaurantRepresentation> {

    @Override
    public  RestaurantRepresentation toModel(Restaurant entity) {
        RestaurantRepresentation restaurantDto = new RestaurantRepresentation();
        restaurantDto.setId(entity.getId());
        restaurantDto.setName(entity.getName());
        restaurantDto.setPrice(entity.getPrice());
        restaurantDto.setCusine_category(entity.getCusine_category());
        restaurantDto.setCity(entity.getCity());
        restaurantDto.setRegion(entity.getRegion());
        restaurantDto.setUrl(entity.getUrl());
        restaurantDto.setCusine_type(entity.getCusine_type());
        restaurantDto.setTime(entity.getTime());
        restaurantDto.setRating(entity.getRating());
        restaurantDto.setRating_type(entity.getRating_type());
        restaurantDto.setVotes(entity.getVotes());
        restaurantDto.add(WebMvcLinkBuilder.linkTo(methodOn(RestaurantsController.class)
                .findbyId(restaurantDto.getId())).withRel("RestaurantLink"));
        return restaurantDto;
    }
}
