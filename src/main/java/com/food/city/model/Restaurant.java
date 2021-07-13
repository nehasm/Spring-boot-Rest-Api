package com.food.city.model;

import javax.persistence.*;
import java.util.Objects;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.hateoas.RepresentationModel;

@Entity
@Table(name="restaurant")
@EntityListeners(AuditingEntityListener.class)
public class Restaurant extends RepresentationModel<Restaurant> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",
            nullable=false)
    private Long id;

    private String name;
//    private String price;
    private Integer price;
    private String cusine_category;
    private String city;
    private String region;
    private String url;
    private String pageno;
    private String cusine_type;
    private String time;
    private Float rating;
    private  String rating_type;
    private String votes;

    @Override
    public String toString() {
        return "restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", cusine_category='" + cusine_category + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", url='" + url + '\'' +
                ", pageno='" + url + '\'' +
                ", cusine_type='" + cusine_type + '\'' +
                ", time='" + time + '\'' +
                ", rating=" + rating +
                ", rating_type='" + rating_type + '\'' +
                ", votes=" + votes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(price, that.price) && Objects.equals(cusine_category, that.cusine_category) && Objects.equals(city, that.city) && Objects.equals(region, that.region) && Objects.equals(url, that.url) && Objects.equals(pageno, that.pageno) && Objects.equals(cusine_type, that.cusine_type) && Objects.equals(time, that.time) && Objects.equals(rating, that.rating) && Objects.equals(rating_type, that.rating_type) && Objects.equals(votes, that.votes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, cusine_category, city, region, url, pageno, cusine_type, time, rating, rating_type, votes);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setCusine_category(String cusine_category) {
        this.cusine_category = cusine_category;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPageno() {
        return pageno;
    }

    public void setPageno(String pageno) {
        this.pageno = pageno;
    }

    public void setCusine_type(String cusine_type) {
        this.cusine_type = cusine_type;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public void setRating_type(String rating_type) {
        this.rating_type = rating_type;
    }

    public void setVotes(String votes) {
        this.votes = votes;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public String getCusine_category() {
        return cusine_category;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public String getUrl() {
        return url;
    }

    public String getCusine_type() {
        return cusine_type;
    }

    public String getTime() {
        return time;
    }

    public Float getRating() {
        return rating;
    }

    public String getRating_type() {
        return rating_type;
    }

    public String getVotes() {
        return votes;
    }


}
