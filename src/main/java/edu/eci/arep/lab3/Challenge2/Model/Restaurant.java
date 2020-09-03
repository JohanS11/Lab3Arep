package edu.eci.arep.lab3.Challenge2.Model;

public class Restaurant {
    private String borough;
    private String name;
    private int restaurant_id;
    private String cuisine;

    public Restaurant(int restaurant_id, String name,String borough, String cuisine) {
        this.borough = borough;
        this.name = name;
        this.restaurant_id = restaurant_id;
        this.cuisine = cuisine;
    }

    public String getBorough() {
        return borough;
    }

    public void setBorough(String borough) {
        this.borough = borough;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    @Override
    public String toString() {
        return "{\"name\":\""+getName()+"\",\"borough\":"+getBorough()+",\"cuisine\":\""+getCuisine()+ ",\"restaurant_id\":\""+getRestaurant_id()+"}";
    }
}
