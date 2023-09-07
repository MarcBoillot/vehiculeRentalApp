package fr.cnaps.vehiculeRental.vehiculeRentalApp.repository;

import fr.cnaps.vehiculeRental.vehiculeRentalApp.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation,Integer> {
}
