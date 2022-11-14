package com.gestionDePov.GestionPov.Service;

import com.gestionDePov.GestionPov.DTO.ClientDTO;
import com.gestionDePov.GestionPov.DTO.SeanceDTO;
import com.gestionDePov.GestionPov.Model.Client;

import java.util.List;

public interface ClientService {

    ClientDTO save(ClientDTO client);
    void delete(Long client);

    List<ClientDTO> findAll();

}
