package com.gestionDePov.GestionPov.Mapping;

import com.gestionDePov.GestionPov.DTO.ContactDTO;
import com.gestionDePov.GestionPov.DTO.SeanceDTO;
import com.gestionDePov.GestionPov.Model.Contact;
import com.gestionDePov.GestionPov.Model.Seance;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class SeanceMapper {

    @Autowired
    DozerBeanMapper dozerBeanMapper;

    @Autowired
    PovMapper povMapper;


    //Entity To Dto
    public SeanceDTO SeanceToSeanceDTO(Seance seance){
        SeanceDTO seanceDTO = dozerBeanMapper.map(seance,SeanceDTO.class);

        if(seanceDTO.getPov() != null){
            seanceDTO.setPov(povMapper.PovToPovDTO(seance.getPov()));
        }
        return seanceDTO;
    }
    //       Dto To Entity
    public Seance SeanceDtoToSeance (SeanceDTO seancedto){
        Seance seance = dozerBeanMapper.map(seancedto,Seance.class);

        if(seance.getPov() != null){
            seance.setPov(povMapper.PovDtoToPov(seancedto.getPov()));
        }
        return seance;
    }
    //
    //List Dto To List Entity
    public List<SeanceDTO> ListSeanceDTOToEntitySeance (List < Seance > seances) {

        List<SeanceDTO> seanceDTOS = new ArrayList<>();
        seances.forEach(SeanceDTO -> seanceDTOS.add(SeanceToSeanceDTO(SeanceDTO)));

        return seanceDTOS;
    }


//List Entity To List DTO
    public List<Seance> ListEntitySeanceToEntitySeance (List <SeanceDTO> seanceDTOS) {

        List<Seance> seances = new ArrayList<>();
        seanceDTOS.forEach(Seance -> seances.add(SeanceDtoToSeance(Seance)));
        return seances;

    }

}
