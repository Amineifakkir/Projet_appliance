package com.gestionDePov.GestionPov.Controller;

import com.gestionDePov.GestionPov.Model.Client;
import com.gestionDePov.GestionPov.Service.serviceImplementation.ClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Client")
public class ClientController {
    private final ClientImpl client;
@Autowired
    public ClientController(ClientImpl client) {
        this.client = client;
    }

    @GetMapping("/GetClient")
    public Client GetClient(Client clients){
        return client.save(clients);
    }
}
