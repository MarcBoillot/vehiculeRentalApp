package fr.cnaps.vehiculeRental.vehiculeRentalApp.service;


import fr.cnaps.vehiculeRental.vehiculeRentalApp.model.Client;
import fr.cnaps.vehiculeRental.vehiculeRentalApp.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    public Optional<Client> finById(int id){
        return clientRepository.findById(id);
    }

    public Client save(Client client){
        return clientRepository.save(client);
    }

    public String delete( Client car){
        clientRepository.delete(car);
        return "Succesfully Deleted";
    }

    public String update(Client car){
        clientRepository.save(car);
        return "succesfully modify";
    }
}