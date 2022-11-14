package com.gestionDePov.GestionPov.Mapping;

import com.gestionDePov.GestionPov.DTO.ApplianceDTO;;
import com.gestionDePov.GestionPov.Model.Appliance;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

public class ApplianceMapper {
    @Autowired
    DozerBeanMapper dozerBeanMapper;

    @Autowired
    TypeMapper typeMapper;

    //Entity To Dto
    public ApplianceDTO ApplianceToApplianceDTO(Appliance appliance){

        ApplianceDTO applianceDTO = dozerBeanMapper.map(appliance, ApplianceDTO.class);

        if(appliance.getIdType()!= null){
            appliance.setIdType(typeMapper.TypeDTOToType(applianceDTO.getIdTypeDTO()));
        }
        return applianceDTO;
    }
    //Dto To Entity
    public Appliance ApplianceDTOToAppliance(ApplianceDTO applianceDTO){
        Appliance appliance = dozerBeanMapper.map(applianceDTO, Appliance.class);

        if(appliance.getIdType()!= null){
            appliance.setIdType(typeMapper.TypeDTOToType(applianceDTO.getIdTypeDTO()));
        }
        return appliance;
    }

    //List Dto To List Entity
    public List<Appliance> ListApplianceDTOToEntityAppliance (List<ApplianceDTO> App) {

        List<Appliance> LstTypeDto = new ArrayList<>();
        App.forEach(ApplianceDTO -> LstTypeDto.add(ApplianceDTOToAppliance(ApplianceDTO)));
        return LstTypeDto;

    }

    //List Entity To List DTO
    public List<ApplianceDTO> ListEntityApplianceToEntityAppliance(List<Appliance> App){

        List<ApplianceDTO> LstType = new ArrayList<>();
        App.forEach(Entitytype -> LstType.add(ApplianceToApplianceDTO(Entitytype)));
        return LstType;

    }



}
