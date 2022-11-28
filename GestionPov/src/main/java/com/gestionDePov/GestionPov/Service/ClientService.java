package com.gestionDePov.GestionPov.Service;

import com.gestionDePov.GestionPov.DTO.ClientDTO;

import com.gestionDePov.GestionPov.DTO.ClientPageDto;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ClientService {

    ClientDTO save(ClientDTO client);
    void delete(Long client);

    ClientPageDto findAll(Pageable pageRequest);

    ClientDTO Update(Long idClient, ClientDTO clientDTO);

}
