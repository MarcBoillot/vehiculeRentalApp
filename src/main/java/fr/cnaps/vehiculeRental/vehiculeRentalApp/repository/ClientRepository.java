package fr.cnaps.vehiculeRental.vehiculeRentalApp.repository;

import fr.cnaps.vehiculeRental.vehiculeRentalApp.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client,Integer> {
}
