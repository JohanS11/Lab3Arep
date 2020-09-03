package edu.eci.arep.lab3.Challenge2.Service;

import edu.eci.arep.lab3.Challenge2.Model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public interface RestaurantServices {


    public ArrayList<Restaurant> getRestaurants();

    public void AddRestaurant(String restaurant);

}
