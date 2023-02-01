package api.byFOOD.api.controller;
import api.byFOOD.api.restaurant.DataRegisterRestaurant;
import api.byFOOD.api.restaurant.Restaurant;
import api.byFOOD.api.restaurant.RestaurantRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/restaurants")
public class RestaurantsController {
    @Autowired
    private RestaurantRepository repository;
    @CrossOrigin(origins = {"http://127.0.0.1:5173","https://your-best-meal.vercel.app"} )
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DataRegisterRestaurant data){
        repository.save(new Restaurant(data));
    }
    @CrossOrigin(origins = {"http://127.0.0.1:5173","https://your-best-meal.vercel.app"} )
    @GetMapping
    public Page<Restaurant> listRestaurant(Pageable pagination){
        return repository.findAll(pagination);
    }
}
