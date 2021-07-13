package com.food.city.mapper;

import com.food.city.dto.RestaurantDto;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

public class RestaurantFileRowMapper implements FieldSetMapper<RestaurantDto> {
    @Override
    public RestaurantDto mapFieldSet(FieldSet fieldSet) {
        RestaurantDto restaurant = new RestaurantDto();
        restaurant.setName(fieldSet.readString("name"));
        restaurant.setPrice(fieldSet.readInt("price"));
        restaurant.setCusine_category(fieldSet.readString("cusine_category"));
        restaurant.setCity(fieldSet.readString("city"));
        restaurant.setRegion(fieldSet.readString("region"));
        restaurant.setUrl(fieldSet.readString("url"));
        restaurant.setPageno(fieldSet.readString("pageno"));
        restaurant.setCusine_type(fieldSet.readString("cusine_type"));
        restaurant.setTime(fieldSet.readString("time"));
        restaurant.setRating(fieldSet.readFloat("rating"));
        restaurant.setRating_type(fieldSet.readString("rating_type"));
        restaurant.setVotes(fieldSet.readString("votes"));
      return restaurant;
    }
}
