package com.food.city.exception;

public class RestaurantNotFoundException extends  RuntimeException{

    private static final long serialVersionUID = 1L;

    RestaurantNotFoundException() {
        super();
    }

    public RestaurantNotFoundException(String message) {
        super(message);
    }
}


