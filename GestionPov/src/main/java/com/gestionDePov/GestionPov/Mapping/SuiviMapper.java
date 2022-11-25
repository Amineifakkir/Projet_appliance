package com.gestionDePov.GestionPov.Mapping;

import com.gestionDePov.GestionPov.DTO.POVDTO;
import com.gestionDePov.GestionPov.DTO.SuiviDTO;
import com.gestionDePov.GestionPov.Model.Suivi;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class SuiviMapper {
    @Autowired
    DozerBeanMapper dozerBeanMapper;

    @Autowired
    TypePrestationMapper typePrestationMapper;

    @Autowired
    PovMapper povMapper;

    //Entity To Dto
    public SuiviDTO SuiviToSuiviDTO(Suivi suivi){

        SuiviDTO suiviDTO = dozerBeanMapper.map(suivi,SuiviDTO.class);

        if(suiviDTO.getTypePres()!= null || suiviDTO.getPovSuivi()!= null ){
            suiviDTO.setTypePres(typePrestationMapper.TypeToTypeDTO(suivi.getTypePres()));
            suiviDTO.setPovSuivi(povMapper.PovToPovDTO(suivi.getPovSuivi()));
        }
        return suiviDTO;
    }
    //Dto To Entity
    public  Suivi SuiviDTOToSuivi( SuiviDTO  suiviDTO){
        Suivi suivi = dozerBeanMapper.map(suiviDTO, Suivi.class);

        if(suivi.getTypePres()!= null || suivi.getPovSuivi()!= null ){
            suivi.setTypePres(typePrestationMapper.TypeDTOToType(suiviDTO.getTypePres()));
            suivi.setPovSuivi(povMapper.PovDtoToPov(suiviDTO.getPovSuivi()));
        }
        return suivi;
    }

    //List Dto To List Entity
    public List<Suivi> ListSuiviDTOToEntitySuivi (List<SuiviDTO> suivi) {

        List<Suivi> suivis = new ArrayList<>();
        suivi.forEach(SuiviDTO -> suivis.add(SuiviDTOToSuivi(SuiviDTO)));
        return suivis;

    }

    //List Entity To List DTO
    public List<SuiviDTO> ListEntitySuiviToDtoSuivi(List<Suivi> suivi){

        List<SuiviDTO> suiviDTOS = new ArrayList<>();
        suivi.forEach(Suivi -> suiviDTOS.add(SuiviToSuiviDTO(Suivi)));
        return suiviDTOS;

    }

}
