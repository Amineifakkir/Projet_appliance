package com.gestionDePov.GestionPov.Mapping;

import com.gestionDePov.GestionPov.DTO.ApplianceDTO;
import com.gestionDePov.GestionPov.DTO.ClientDTO;
import com.gestionDePov.GestionPov.DTO.POVDTO;
import com.gestionDePov.GestionPov.Model.Appliance;
import com.gestionDePov.GestionPov.Model.Client;
import com.gestionDePov.GestionPov.Model.POV;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PovMapper {
    @Autowired
    DozerBeanMapper dozerBeanMapper;
    @Autowired
    ClientMapper clientMapper;

    @Autowired
    ApplianceMapper applianceMapper;

    //Entity To Dto
    public POVDTO PovToPovDTO(POV pov){
        POVDTO povDTO = dozerBeanMapper.map(pov,POVDTO.class);
        if(povDTO.getIdAppliance()!= null && povDTO.getIdClient()!= null){
            povDTO.setIdAppliance(applianceMapper.ApplianceToApplianceDTO(pov.getIdAppliance()));
            povDTO.setIdClient(clientMapper.ClientToClientDTO(pov.getIdClient()));
        }
        return povDTO;
    }
    //  Dto To Entity
    public POV PovDtoToPov(POVDTO povdto){
        POV pov = dozerBeanMapper.map(povdto,POV.class);
        if(pov.getIdAppliance()!= null && pov.getIdClient()!= null){
            pov.setIdAppliance(applianceMapper.ApplianceDTOToAppliance(povdto.getIdAppliance()));
            pov.setIdClient(clientMapper.ClientDTOToClient(povdto.getIdClient()));
        }
        return pov;

    }
    //
    //List Dto To List Entity
    public List<POV> ListPovDTOToEntityPov(List<POVDTO> povdtos){

        List<POV> povs = new ArrayList<>();
        povdtos.forEach(Pov -> povs.add(PovDtoToPov(Pov)));
        return povs;

    }

    //List Entity To List DTO
    public List<POVDTO> ListPovToPovDto(List<POV> povs){

        List<POVDTO> povdtos = new ArrayList<>();
        povs.forEach(Pov ->povdtos.add(PovToPovDTO(Pov)));
        return povdtos;

    }

    ////////////////////////////////////////////// CLIENT //////////////////////////////////////////////

//    public ClientDTO ClientToClientDTO(Client client){
//        ClientDTO clientDTO = dozerBeanMapper.map(client,ClientDTO.class);
//        return clientDTO;
//    }
//    //    //    Dto To Entity
//    public Client ClientDTOToClient(ClientDTO clientDTO){
//       Client client = dozerBeanMapper.map(clientDTO,Client.class);
//        return client;
//    }
//    //
//    //List Dto To List Entity
//    public List<Client> ListClientDTOToEntityClient(List<ClientDTO> clientDTOS){
//
//        List<Client> clients = new ArrayList<>();
//        clientDTOS.forEach(ClientDTO -> clients.add(ClientDTOToClient(ClientDTO)));
//        return clients;
//
//    }
//    //
////    //List Entity To List DTO
//    public List<ClientDTO> ListClientToClientDto(List<Client> clients){
//
//        List<ClientDTO> clientDTOS = new ArrayList<>();
//        clients.forEach(Client -> clientDTOS.add(ClientToClientDTO(Client)));
//        return clientDTOS;
//
//    }


}
