package com.gestionDePov.GestionPov.Mapping;

import com.gestionDePov.GestionPov.DTO.TypeDTO;
import com.gestionDePov.GestionPov.Model.Type;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TypeMapper {

    //Creation des Methodes
    @Autowired
    DozerBeanMapper dozerBeanMapper;

    //Entity To Dto

    public TypeDTO TypeToTypeDTO(Type tp){
        TypeDTO tpDTO = dozerBeanMapper.map(tp,TypeDTO.class);


        return tpDTO;
    }
//    Dto To Entity

    public Type TypeDTOToType(TypeDTO type){
    Type tpDto = dozerBeanMapper.map(type,Type.class);
    return tpDto;
}

//List Dto To List Entity

    public List<Type> ListTypeDTOToEntityType(List<TypeDTO> type){

        List<Type> LstTypeDto = new ArrayList<>();
        type.forEach(typeDTO -> LstTypeDto.add(TypeDTOToType(typeDTO)));
        return LstTypeDto;

    }

    //List Entity To List DTO

    public List<TypeDTO> ListEntityTypeToEntityType(List<Type> type){

        List<TypeDTO> LstType = new ArrayList<>();
        type.forEach(Entitytype -> LstType.add(TypeToTypeDTO(Entitytype)));
        return LstType;

    }

}
