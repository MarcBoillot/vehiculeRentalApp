package fr.cnaps.vehiculeRental.vehiculeRentalApp.service;


import fr.cnaps.vehiculeRental.vehiculeRentalApp.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.cnaps.vehiculeRental.vehiculeRentalApp.model.Car;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public Iterable<Car> findAll() {
        return carRepository.findAll();
    }

    public Optional<Car> findById(int id){
        return carRepository.findById(id);
    }

    public Car save(Car car){
        return carRepository.save(car);
    }

    public String delete( Car car){
        carRepository.delete(car);
        return "Succesfully Deleted";
    }

    public String update(Car car){
        carRepository.save(car);
        return "succesfully modify";
    }
}