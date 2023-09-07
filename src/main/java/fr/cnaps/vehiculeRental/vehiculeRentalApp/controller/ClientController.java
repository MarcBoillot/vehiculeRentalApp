package fr.cnaps.vehiculeRental.vehiculeRentalApp.controller;


import fr.cnaps.vehiculeRental.vehiculeRentalApp.model.Car;
import fr.cnaps.vehiculeRental.vehiculeRentalApp.model.Client;
import fr.cnaps.vehiculeRental.vehiculeRentalApp.service.CarService;
import fr.cnaps.vehiculeRental.vehiculeRentalApp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public @ResponseBody Iterable<Client> getAllCars() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<Client> getCarsById(@PathVariable(value = "id") int id){
        return clientService.finById(id);
    }

    @PostMapping(value = "/add")
    public @ResponseBody Client CreateCars(@RequestBody Client client){
        return clientService.save(client);
    }

    @DeleteMapping(value = "/delete")
    public @ResponseBody String RemoveCar(@RequestBody Client client){
        clientService.delete(client);
        return "Succesfully Deleted";
    }

    @PutMapping(value = "/modify")
    public @ResponseBody String ModifyClient(@RequestBody Client client){
        clientService.update(client);
        return "succesfully modify";
    }
}