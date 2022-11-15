package com.gestionDePov.GestionPov.Controller;


import com.gestionDePov.GestionPov.DTO.ClientDTO;
import com.gestionDePov.GestionPov.Service.ClientService;
import com.gestionDePov.GestionPov.Service.serviceImplementation.ClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Client")
public class ClientController {
    @Autowired
    private ClientService client;


    @PostMapping("/add")
    public ClientDTO getClient(@RequestBody ClientDTO clientDTO) {
        return client.save(clientDTO);
    }
    @GetMapping("/FindClient")
    public List<ClientDTO> findClient() {
        return client.findAll();
    }
    @DeleteMapping("/DeleteClient/{iClient}")
    public void deleteClient(@PathVariable("idClient") Long idClient) {
        client.delete(idClient);
    }


    @PutMapping("/Update/{idClient}")
    public  ClientDTO updateClient(@PathVariable("idClient") Long idClient, @RequestBody ClientDTO clientDTO){
        return client.Update(idClient,clientDTO);
    }
}
