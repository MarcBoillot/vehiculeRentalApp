package fr.cnaps.vehiculeRental.vehiculeRentalApp.service;
import java.time.Duration;

import fr.cnaps.vehiculeRental.vehiculeRentalApp.model.Car;
import fr.cnaps.vehiculeRental.vehiculeRentalApp.model.Client;
import fr.cnaps.vehiculeRental.vehiculeRentalApp.model.Reservation;
import fr.cnaps.vehiculeRental.vehiculeRentalApp.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.time.LocalDateTime;

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

    public Reservation save(Reservation reservation) {
        int clientid = reservation.getClients_id();
        Optional<Client> clientDB = clientService.finById(clientid);
        int carid = reservation.getCars_id();
        Optional<Car> carDB = carService.findById(carid);

        if(clientDB.isPresent() && clientHaveMajority(clientDB)){
            int pricekm = carDB.get().getPricekm();
            int price = carDB.get().getPrice();
            int priceresa = price + (pricekm * reservation.getKilometer());
            reservation.setPrice_resa(priceresa);
            return reservationRepository.save(reservation);
        }
        return null;
    }








    private static boolean clientHaveMajority(Optional<Client> clientDB) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime previous = clientDB.get().getBirthday();
        Duration duration = Duration.between(previous,now);
        int majority = 18*365*24*3600;
        if(duration.getSeconds() > majority){
            return true;
        }
        return false;
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