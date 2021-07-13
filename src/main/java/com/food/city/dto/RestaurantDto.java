package com.food.city.dto;

public class RestaurantDto {
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
    private String rating_type;
    private String votes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCusine_category() {
        return cusine_category;
    }

    public void setCusine_category(String cusine_category) {
        this.cusine_category = cusine_category;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getUrl() {
        return url;
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

    public String getCusine_type() {
        return cusine_type;
    }

    public void setCusine_type(String cusine_type) {
        this.cusine_type = cusine_type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getRating_type() {
        return rating_type;
    }

    public void setRating_type(String rating_type) {
        this.rating_type = rating_type;
    }

    public String getVotes() {
        return votes;
    }

    public void setVotes(String votes) {
        this.votes = votes;
    }


}
