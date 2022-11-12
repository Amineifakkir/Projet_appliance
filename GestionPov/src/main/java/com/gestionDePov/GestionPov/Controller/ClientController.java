package com.gestionDePov.GestionPov.Controller;

import com.gestionDePov.GestionPov.DTO.ClientDTO;
import com.gestionDePov.GestionPov.Model.Client;
import com.gestionDePov.GestionPov.Service.ClientService;
import com.gestionDePov.GestionPov.Service.serviceImplementation.ClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Client")
public class ClientController {
    private final ClientService client;
@Autowired
    public ClientController(ClientImpl client) {
        this.client = client;
    }

    @GetMapping("/GetClient")
    public ClientDTO GetClient(ClientDTO clients){
        return client.save(clients);
    }
}
