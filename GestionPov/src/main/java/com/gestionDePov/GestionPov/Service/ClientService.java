package com.gestionDePov.GestionPov.Service;

import com.gestionDePov.GestionPov.DTO.ClientDTO;
import com.gestionDePov.GestionPov.Model.Client;

public interface ClientService {

    ClientDTO save(ClientDTO client);
    void delete(Long client);
}
