package fr.cnaps.vehiculeRental.vehiculeRentalApp.service;
import java.util.*;

import fr.cnaps.vehiculeRental.vehiculeRentalApp.model.Car;
import fr.cnaps.vehiculeRental.vehiculeRentalApp.model.Client;
import fr.cnaps.vehiculeRental.vehiculeRentalApp.model.Reservation;
import fr.cnaps.vehiculeRental.vehiculeRentalApp.repository.ReservationRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private CarService carService;
    @Autowired
    private ClientService clientService;


    public Iterable<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> finById(int id){
        return reservationRepository.findById(id);
    }

    public Reservation save(Reservation reservation){


        int carid = reservation.getCars_id();
        Optional<Car> carDB = carService.findById(carid);
        if(carDB.isPresent()){
            int pricekm = carDB.get().getPricekm();
            int price = carDB.get().getPrice();
            int priceresa = price + (pricekm * reservation.getKilometer());
            reservation.setPrice_resa(priceresa);
        }
        return reservationRepository.save(reservation);
    }

    public String delete( Reservation reservation){
        reservationRepository.delete(reservation);
        return "Succesfully Deleted";
    }

    public String update(Reservation reservation){
        reservationRepository.save(reservation);
        return "succesfully modify";
    }
}