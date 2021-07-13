package com.food.city.service;

import com.food.city.exception.RestaurantNotFoundException;
import com.food.city.model.Restaurant;

import java.util.List;
import java.util.Optional;


public interface Restaurantsservice {

    List<Restaurant> findRestaurantsbyCityAndRegion(String city, String region) throws RestaurantNotFoundException;

    Optional<Restaurant> findRestaurantsbyCityAndId(Long id) throws RestaurantNotFoundException;

    List<Restaurant> findRestaurantsbyCity(String city) throws RestaurantNotFoundException;

    List<Restaurant> findRestaurantsbyPrice(String city, Integer price2) throws RestaurantNotFoundException;

    List<Restaurant> findRestaurantsbyRating(String city, Float rating2) throws RestaurantNotFoundException;

    List<Restaurant> findRestaurantsbyNewOpen(String city)  throws RestaurantNotFoundException;

    List<Restaurant> findRestaurantsbyCusine(String city, String item)  throws RestaurantNotFoundException;

    List<Restaurant> findRestaurantsbyCusineType(String city, String item)  throws RestaurantNotFoundException;
}
