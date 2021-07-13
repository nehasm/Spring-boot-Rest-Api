package com.food.city.processor;

import com.food.city.dto.RestaurantDto;
import com.food.city.model.Restaurant;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class RestaurantProcessor  implements ItemProcessor<RestaurantDto, Restaurant> {
    @Override
    public Restaurant process(RestaurantDto restaurantDto) throws Exception {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(restaurantDto.getName());
        restaurant.setPrice(restaurantDto.getPrice());
        restaurant.setCusine_category(restaurantDto.getCusine_category());
        restaurant.setCity(restaurantDto.getCity());
        restaurant.setRegion(restaurantDto.getRegion());
        restaurant.setUrl(restaurantDto.getUrl());
        restaurant.setPageno(restaurantDto.getPageno());
        restaurant.setCusine_type(restaurantDto.getCusine_type());
        restaurant.setTime(restaurantDto.getTime());
        restaurant.setRating(restaurantDto.getRating());
        restaurant.setRating_type(restaurantDto.getRating_type());
        restaurant.setVotes(restaurantDto.getVotes());
        return restaurant;

    }
}
