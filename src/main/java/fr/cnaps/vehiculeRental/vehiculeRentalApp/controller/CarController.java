package fr.cnaps.vehiculeRental.vehiculeRentalApp.controller;

import fr.cnaps.vehiculeRental.vehiculeRentalApp.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import fr.cnaps.vehiculeRental.vehiculeRentalApp.service.CarService;
import java.util.Optional;


@Controller
@RequestMapping(path="/car")
public class CarController {
@Autowired
private CarService carService;

    @GetMapping("/all")
    public @ResponseBody Iterable<Car> getAllCars() {
        return carService.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<Car> getCarsById(@PathVariable(value = "id") int id){
        return carService.findById(id);
    }

    @PostMapping(value = "/add")
    public @ResponseBody Car CreateCars(@RequestBody Car car){
        return carService.save(car);
    }

    @DeleteMapping(value = "/delete")
    public @ResponseBody String RemoveCar(@RequestBody Car car){
        carService.delete(car);
        return "Succesfully Deleted";
    }

    @PutMapping(value = "/modify")
    public @ResponseBody String ModifyCar(@RequestBody Car car){
        carService.update(car);
        return "succesfully modify";
    }
}