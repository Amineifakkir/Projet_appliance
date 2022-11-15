package com.gestionDePov.GestionPov.Mapping;

import com.gestionDePov.GestionPov.DTO.ClientDTO;
import com.gestionDePov.GestionPov.Model.Client;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ClientMapper {

    @Autowired
    DozerBeanMapper dozerBeanMapper;

    //Entity To Dto
    public ClientDTO ClientToClientDTO(Client client){


        return dozerBeanMapper.map(client,ClientDTO.class);
    }
// Dto To Entity
    public Client ClientDTOToClient(ClientDTO Cl){
        Client Clt = dozerBeanMapper.map(Cl,Client.class);
        return Clt;
    }
//
    //List Dto To List Entity
    public List<Client> ListClientDTOToEntityClient(List<ClientDTO> App){

        List<Client> LstTypeDto = new ArrayList<>();
        App.forEach(ClientDTO -> LstTypeDto.add(ClientDTOToClient(ClientDTO)));
        return LstTypeDto;

    }
//
//    //List Entity To List DTO
    public List<ClientDTO> ListEntityClientToEntityClient(List<Client> App){

        List<ClientDTO> LstType = new ArrayList<>();
        App.forEach(Entitytype -> LstType.add(ClientToClientDTO(Entitytype)));
        return LstType;

    }

}
