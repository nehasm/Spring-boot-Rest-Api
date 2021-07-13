package com.food.city.service;

import com.food.city.exception.RestaurantNotFoundException;
import com.food.city.repository.RestaurantRepository;
import com.food.city.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantsserviceImpl implements Restaurantsservice{

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> findRestaurantsbyCityAndRegion(String city, String region) {
            List<Restaurant> restaurants =  restaurantRepository.findAllByCityAndRegion(city,region);
            if(restaurants.isEmpty()){
                throw new RestaurantNotFoundException("No restaurants available in your region");
            }
            return restaurants;
    }

    @Override
    public Optional<Restaurant> findRestaurantsbyCityAndId(Long id) {
        Optional<Restaurant> restaurant =  restaurantRepository.findById(id);
        if(restaurant.isPresent()){
            return restaurant;

        }else{
            throw new RestaurantNotFoundException("Restaurant does not exit");
        }

    }

    @Override
    public List<Restaurant> findRestaurantsbyCity(String city) {
        List<Restaurant> restaurants = restaurantRepository.findAllByCity(city);
        if(restaurants.isEmpty()){
            throw new RestaurantNotFoundException("No restaurants available in your city");
        }
        return restaurants;
    }
    @Override
    public List<Restaurant> findRestaurantsbyPrice(String city, Integer price2) {
        int price1 = price2 - 1000;
        List<Restaurant> restaurants = restaurantRepository.findAllByCityAndPrice(city,price1,price2);
        if(restaurants.isEmpty()){
            throw new RestaurantNotFoundException("No restaurants available with your desired price range.Please try to explore different price range");
        }
        return restaurants;
    }
    @Override
    public List<Restaurant> findRestaurantsbyRating(String city, Float rating2) {
        Float rating1;
        if(rating2==1) {
            rating1 = 0.1F;
        }
        else {
            rating1 = rating2 - 1;
        }
        if(rating2==5) {
            rating2 = 4.9F;
        }
        List<Restaurant> restaurants = restaurantRepository.findAllByCityAndRating(city,rating1,rating2);
        if(restaurants.isEmpty()){
            throw new RestaurantNotFoundException("No restaurants available with this range of ratings");
        }
        return restaurants;
    }
    @Override
    public List<Restaurant> findRestaurantsbyNewOpen(String city) {
        Float sign = 5F;
        List<Restaurant> restaurants = restaurantRepository.findAllByCityAndNewOpen(city,sign);
        if(restaurants.isEmpty()){
            throw new RestaurantNotFoundException("No newly opened restaurants available in your city");
        }
        return restaurants;
    }
    @Override
    public List<Restaurant> findRestaurantsbyCusine(String city, String item) {
        List<Restaurant> restaurants =  restaurantRepository.findAllByCityAndCusine(city,item);
        if(restaurants.isEmpty()){
            throw new RestaurantNotFoundException("No restaurant available in your city to serve "+item+ "cusine");
        }
        return restaurants;
    }
    @Override
    public List<Restaurant> findRestaurantsbyCusineType(String city, String item) {
        List<Restaurant> restaurants =  restaurantRepository.findAllByCityAndCusine_type(city,item);
        if(restaurants.isEmpty()){
            throw new RestaurantNotFoundException("No restaurant available in your city to serve "+item+ "cusine type");
        }
        return restaurants;
    }
}
