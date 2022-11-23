package com.gestionDePov.GestionPov.Service.serviceImplementation;


import com.gestionDePov.GestionPov.DTO.ClientDTO;
import com.gestionDePov.GestionPov.Mapping.ClientMapper;

import com.gestionDePov.GestionPov.Repository.ClientRepo;
import com.gestionDePov.GestionPov.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ClientImpl implements ClientService{

    @Autowired
    ClientRepo clientRepo;
    @Autowired
    ClientMapper clientMapper;


    @Override
    public ClientDTO save(ClientDTO client) {
        return clientMapper.ClientToClientDTO(clientRepo.save(clientMapper.ClientDTOToClient(client)));
    }

    @Override
    public void delete(Long client) {
        boolean exists =clientRepo.existsById(client);
        if (!exists){
            throw new IllegalStateException(
                    "Type with id "+client+" does not exists");
        }
        clientRepo.deleteById(client);

    }

    @Override
    public List<ClientDTO> findAll() {
        return clientMapper.ListEntityClientToDtoClient(clientRepo.findAll());
    }

    @Override
    public ClientDTO Update(Long idClient, ClientDTO clientDTO) {
        boolean exists =clientRepo.existsById(idClient);
        if (exists){
            clientDTO.setIdClt(idClient);
            clientRepo.save(clientMapper.ClientDTOToClient(clientDTO));

        }

        return clientDTO;

    }
}

