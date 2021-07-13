package com.food.city.repository;

import com.food.city.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, String> {


    @Query(nativeQuery = true, value = "SELECT * FROM restaurant r WHERE r.city=?1 and r.region=?2")
    public List<Restaurant> findAllByCityAndRegion(String city, String region);

    Optional<Restaurant> findById(Long id);

    List<Restaurant> findAllByCity(String city);

    @Query(nativeQuery = true, value = "SELECT * FROM restaurant r WHERE r.city=:city and r.price BETWEEN :price1 and :price2")
    List<Restaurant> findAllByCityAndPrice(@Param("city") String city, @Param("price1") Integer price1, @Param("price2") Integer price2);

    @Query(nativeQuery = true, value = "SELECT * FROM restaurant r WHERE r.city=:city and r.rating BETWEEN :rating1 and :rating2")
    List<Restaurant> findAllByCityAndRating(@Param("city")  String city,@Param("rating1") Float rating1,@Param("rating2") Float rating2);

    @Query(nativeQuery = true, value = "SELECT * FROM restaurant r WHERE r.city=:city and r.rating=:sign")
    List<Restaurant> findAllByCityAndNewOpen(@Param("city") String city,@Param("sign") Float sign);

    @Query(nativeQuery = true,value = "SELECT * FROM restaurant r WHERE r.city=:city and r.cusine_category like %:item%")
    List<Restaurant> findAllByCityAndCusine(@Param("city") String city,@Param("item") String item);

    @Query(nativeQuery = true, value = "SELECT * FROM restaurant r WHERE r.city=:city and r.cusine_type=:item")
    List<Restaurant> findAllByCityAndCusine_type(@Param("city") String city, @Param("item") String item);
}
