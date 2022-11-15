package com.gestionDePov.GestionPov.Service;

import com.gestionDePov.GestionPov.DTO.ClientDTO;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ClientService {

    ClientDTO save(ClientDTO client);
    void delete(Long client);

    List<ClientDTO> findAll();

    ClientDTO Update(Long idClient, ClientDTO clientDTO);

}
