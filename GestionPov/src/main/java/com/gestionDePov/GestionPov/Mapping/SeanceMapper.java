package com.gestionDePov.GestionPov.Mapping;


import com.gestionDePov.GestionPov.DTO.SeanceDTO;

import com.gestionDePov.GestionPov.Model.Seance;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class SeanceMapper {

    @Autowired
    DozerBeanMapper dozerBeanMapper;

    @Autowired
    PovMapper povMapper;


    //Entity To Dto
    public SeanceDTO SeanceToSeanceDTO(Seance seance){
        SeanceDTO seanceDTO = dozerBeanMapper.map(seance,SeanceDTO.class);

        if(seanceDTO.getPovSeance() != null){
            seanceDTO.setPovSeance(povMapper.PovToPovDTO(seance.getPovSeance()));
        }
        return seanceDTO;
    }
    //       Dto To Entity
    public Seance SeanceDtoToSeance (SeanceDTO seancedto){
        Seance seance = dozerBeanMapper.map(seancedto,Seance.class);

        if(seance.getPovSeance() != null){
            seance.setPovSeance(povMapper.PovDtoToPov(seancedto.getPovSeance()));
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
    public List<Seance> ListEntitySeanceToDtoSeance (List <SeanceDTO> seanceDTOS) {

        List<Seance> seances = new ArrayList<>();
        seanceDTOS.forEach(Seance -> seances.add(SeanceDtoToSeance(Seance)));
        return seances;

    }

}
