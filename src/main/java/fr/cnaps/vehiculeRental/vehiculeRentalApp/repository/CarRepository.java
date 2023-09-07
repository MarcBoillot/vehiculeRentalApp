package fr.cnaps.vehiculeRental.vehiculeRentalApp.repository;

import fr.cnaps.vehiculeRental.vehiculeRentalApp.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository <Car, Integer>{
}
