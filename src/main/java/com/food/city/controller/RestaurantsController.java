package com.food.city.controller;

import com.food.city.mapper.RestaurantModelMapper;
import com.food.city.repository.RestaurantRepository;
import com.food.city.model.Restaurant;
import com.food.city.dto.RestaurantRepresentation;
import com.food.city.service.Restaurantsservice;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/restaurants")
public class RestaurantsController {

    @Autowired
    private Restaurantsservice restaurantsservice;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantModelMapper restaurantModelMapper;

    @GetMapping("/{city}")
    @ApiOperation(value = "All the Restaurants in the selected City")
    public ResponseEntity<CollectionModel<RestaurantRepresentation>> findbyCity(@PathVariable String city){
        List<RestaurantRepresentation> restaurants = restaurantsservice.findRestaurantsbyCity(city)
                .stream()
                .map(restaurantModelMapper::toModel)
                .collect(Collectors.toList());
        Link link = linkTo(methodOn(RestaurantsController.class)
                .findbyCity(city))
                .withSelfRel();
        CollectionModel<RestaurantRepresentation> result = CollectionModel.of(restaurants, link);
        HttpHeaders header = new HttpHeaders();
        header.add("description","All the Restaurants in City");
        return ResponseEntity.status(HttpStatus.OK).headers(header).body(result);
    }

    @GetMapping("/{city}/{region}/region")
    @ApiOperation(value = "All the Restaurants in the selected Region")
    public ResponseEntity<CollectionModel<RestaurantRepresentation>> findbyRegion(@PathVariable String city, @PathVariable String region){
        List<RestaurantRepresentation> restaurantList = restaurantsservice.findRestaurantsbyCityAndRegion(city,region)
                .stream()
                .map(restaurantModelMapper::toModel)
                .collect(Collectors.toList());
        Link link = linkTo(methodOn(RestaurantsController.class)
                .findbyRegion(city,region))
                .withSelfRel();
        CollectionModel<RestaurantRepresentation> result = CollectionModel.of(restaurantList, link);
        HttpHeaders header = new HttpHeaders();
        header.add("description","Showing the all the restaurants with respect to city and region");
        return ResponseEntity.status(HttpStatus.OK).headers(header).body(result);
    }

    @GetMapping("/{city}/{price}/price")
    @ApiOperation("Restaurants in a selected price range")
    public ResponseEntity<CollectionModel<RestaurantRepresentation>> findbyPrice(@PathVariable String city, @PathVariable Integer price){
        List<RestaurantRepresentation> restaurants_price = restaurantsservice.findRestaurantsbyPrice(city,price)
                .stream()
                .map(restaurantModelMapper::toModel)
                .collect(Collectors.toList());
        Link link = linkTo(methodOn(RestaurantsController.class)
                .findbyPrice(city,price))
                .withSelfRel();
        CollectionModel<RestaurantRepresentation> result = CollectionModel.of(restaurants_price, link);
        HttpHeaders header = new HttpHeaders();
        header.add("description","Restaurants in a price range");
        return ResponseEntity.status(HttpStatus.OK).headers(header).body(result);
    }

    @GetMapping("/{city}/{rating}/rating")
    @ApiOperation("Restaurants in a selected rating range")
    public ResponseEntity<CollectionModel<RestaurantRepresentation>> findbyRating(@PathVariable String city,@PathVariable Float rating){
        List<RestaurantRepresentation> restaurants_rating = restaurantsservice.findRestaurantsbyRating(city,rating)
                .stream()
                .map(restaurantModelMapper::toModel)
                .collect(Collectors.toList());
        Link link = linkTo(methodOn(RestaurantsController.class)
                .findbyRating(city,rating))
                .withSelfRel();
        CollectionModel<RestaurantRepresentation> result = CollectionModel.of(restaurants_rating, link);
        HttpHeaders header = new HttpHeaders();
        header.add("description","Restaurants in a rating range");
        return ResponseEntity.status(HttpStatus.OK).headers(header).body(result);
    }

    @GetMapping("/{city}/new")
    @ApiOperation("All the newly opened restaurants in a city")
    public ResponseEntity<CollectionModel<RestaurantRepresentation>> findbyNewOpen(@PathVariable String city){
        List<RestaurantRepresentation> restaurants_new = restaurantsservice.findRestaurantsbyNewOpen(city)
                .stream()
                .map(restaurantModelMapper::toModel)
                .collect(Collectors.toList());
        Link link = linkTo(methodOn(RestaurantsController.class)
                .findbyNewOpen(city))
                .withSelfRel();
        CollectionModel<RestaurantRepresentation> result = CollectionModel.of(restaurants_new, link);
        HttpHeaders header = new HttpHeaders();
        header.add("description","All newly opened restaurants");
        return ResponseEntity.status(HttpStatus.OK).headers(header).body(result);
    }

    @GetMapping("/{city}/{item}/cusine_category")
    @ApiOperation("Restaurants serving selected Cusines")
    public ResponseEntity<List<RestaurantRepresentation>> findbyCuisine(@PathVariable String city,@PathVariable String item){
        List<RestaurantRepresentation> restaurants_cusine = restaurantsservice.findRestaurantsbyCusine(city,item)
                .stream()
                .map(restaurantModelMapper::toModel)
                .collect(Collectors.toList());
        Link link = linkTo(methodOn(RestaurantsController.class)
                .findbyCuisine(city,item))
                .withSelfRel();
        CollectionModel<RestaurantRepresentation> result = CollectionModel.of(restaurants_cusine, link);
        HttpHeaders header = new HttpHeaders();
        header.add("description","Restaurants serves the given cusine");
        return ResponseEntity.status(HttpStatus.OK).headers(header).body(restaurants_cusine);
    }

    @GetMapping("/{city}/{item}/cusine_type")
    @ApiOperation("Restaurants serving selected Cusine type")
    public ResponseEntity<CollectionModel<RestaurantRepresentation>> findbyCuisineType(@PathVariable String city,@PathVariable String item){
        List<RestaurantRepresentation> restaurants_cusine = restaurantsservice.findRestaurantsbyCusineType(city,item)
                .stream()
                .map(restaurantModelMapper::toModel)
                .collect(Collectors.toList());
        Link link = linkTo(methodOn(RestaurantsController.class)
                .findbyCuisineType(city,item))
                .withSelfRel();
        CollectionModel<RestaurantRepresentation> result = CollectionModel.of(restaurants_cusine, link);
        HttpHeaders header = new HttpHeaders();
        header.add("description","Restaurants has the given cusine in menu");
        return ResponseEntity.status(HttpStatus.OK).headers(header).body(result);
    }

    @GetMapping("/city/{id}")
    public ResponseEntity<Optional<Restaurant>> findbyId(@PathVariable Long id){
        Optional<Restaurant> restaurant_id = restaurantsservice.findRestaurantsbyCityAndId(id);
        HttpHeaders header = new HttpHeaders();
        header.add("description","Individual restaurant with ID");
        return ResponseEntity.status(HttpStatus.OK).headers(header).body(restaurant_id);
    }
}
