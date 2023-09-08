package fr.cnaps.vehiculeRental.vehiculeRentalApp.controller;

import fr.cnaps.vehiculeRental.vehiculeRentalApp.model.Car;
import fr.cnaps.vehiculeRental.vehiculeRentalApp.model.Client;
import fr.cnaps.vehiculeRental.vehiculeRentalApp.model.Reservation;
import fr.cnaps.vehiculeRental.vehiculeRentalApp.service.CarService;
import fr.cnaps.vehiculeRental.vehiculeRentalApp.service.ClientService;
import fr.cnaps.vehiculeRental.vehiculeRentalApp.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public @ResponseBody Iterable<Reservation> getAllReservation() {
        return reservationService.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<Reservation> getReservationById(@PathVariable(value = "id") int id){
        return reservationService.finById(id);
    }

    @PostMapping(value = "/add")
    public @ResponseBody String CreateReservation(@RequestBody Reservation reservation) {
        if(reservationService.save(reservation)==null){
            return "reservation refused";
        }
        return "Reservation successfuly";
    }

    @DeleteMapping(value = "/delete")
    public @ResponseBody String RemoveReservation(@RequestBody Reservation reservation){
        reservationService.delete(reservation);
        return "Succesfully Deleted";
    }

    @PutMapping(value = "/modify")
    public @ResponseBody String ModifyReservation(@RequestBody Reservation reservation){
        reservationService.update(reservation);
        return "succesfully modify";
    }
}