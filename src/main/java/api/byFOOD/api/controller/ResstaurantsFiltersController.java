package api.byFOOD.api.controller;
import api.byFOOD.api.filters.FilterData;
import api.byFOOD.api.restaurant.Restaurant;
import api.byFOOD.api.restaurant.RestaurantRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.*;

@RestController
@RequestMapping("/restaurants/filters")
public class ResstaurantsFiltersController {
    @Autowired
    private RestaurantRepository repository;

    @CrossOrigin(origins = {"http://127.0.0.1:5173","https://your-best-meal.vercel.app"} )
    @PostMapping
    public List<Restaurant> listRestaurant(@RequestBody FilterData filterData){
        List<Restaurant> allRestaurants = repository.findAll();
        List<Restaurant> resultFiltered = allRestaurants;

        if(filterData.nameToMatch() != "" || filterData.nameToMatch() != null){
            resultFiltered = allRestaurants.stream().filter(restaurant -> StringUtils.containsIgnoreCase(restaurant.getName(), filterData.nameToMatch())).toList();
        }

        if(!Double.isNaN(filterData.distance_wanted()) && filterData.distance_wanted() != 0){
            resultFiltered =  resultFiltered.stream().filter(restaurant -> restaurant.getDistance() <= filterData.distance_wanted()).toList();
        }

        if(!Double.isNaN(filterData.price_wanted())&& filterData.price_wanted() != 0){
            resultFiltered =  resultFiltered.stream().filter(restaurant -> restaurant.getPrice() <= filterData.price_wanted()).toList();
        }

        if(!Double.isNaN(filterData.customer_rating_wanted())&& filterData.customer_rating_wanted() != 0){
            resultFiltered =  resultFiltered.stream().filter(restaurant -> restaurant.getCustomer_rating() >= filterData.customer_rating_wanted()).toList();
        }

        if(!Double.isNaN(filterData.cuisine_id_wanted())&& filterData.cuisine_id_wanted() != 0){
            resultFiltered =  resultFiltered.stream().filter(restaurant -> restaurant.getCuisine_id() == filterData.cuisine_id_wanted()).toList();
        }

        ArrayList<Restaurant> resultFilteredArrayList = new ArrayList<>((resultFiltered));
        Collections.sort(resultFilteredArrayList, Comparator.comparing(Restaurant::getDistance));

        if(resultFilteredArrayList.size() > 5){
            List subList = resultFilteredArrayList.subList(0, 5);
            return subList;
        }

        return resultFilteredArrayList;
    }
}
