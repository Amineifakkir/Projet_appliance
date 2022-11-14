package com.gestionDePov.GestionPov.Mapping;


import com.gestionDePov.GestionPov.DTO.TypePrestationDTO;

import com.gestionDePov.GestionPov.Model.TypePrestation;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
public class TypePrestationMapper {
@Autowired
DozerBeanMapper dozerBeanMapper;

    public TypePrestationDTO TypeToTypeDTO(TypePrestation tp){
        TypePrestationDTO tpDTO = dozerBeanMapper.map(tp,TypePrestationDTO.class);


        return tpDTO;
    }
    //    Dto To Entity
    public TypePrestation TypeDTOToType(TypePrestationDTO type){
        TypePrestation tpDto = dozerBeanMapper.map(type,TypePrestation.class);
        return tpDto;
    }

    //List Dto To List Entity
    public List<TypePrestation> ListTypeDTOToEntityType(List<TypePrestationDTO> type){

        List<TypePrestation> LstTypeDto = new ArrayList<>();
        type.forEach(typeDTO -> LstTypeDto.add(TypeDTOToType(typeDTO)));
        return LstTypeDto;

    }

    //List Entity To List DTO
    public List<TypePrestationDTO> ListEntityTypePrestationToDTOTypePrestation(List<TypePrestation> type){

        List<TypePrestationDTO> LstType = new ArrayList<>();
        type.forEach(Entitytype -> LstType.add(TypeToTypeDTO(Entitytype)));
        return LstType;

    }

}

