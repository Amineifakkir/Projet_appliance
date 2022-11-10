package com.gestionDePov.GestionPov.Service.serviceImplementation;


import com.gestionDePov.GestionPov.Model.Client;
import com.gestionDePov.GestionPov.Repository.ClientRepo;
import com.gestionDePov.GestionPov.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientImpl implements ClientService{

    @Autowired
    ClientRepo clientRepo;

    public Client save(Client client) {
        return clientRepo.save(client);
    }
}
