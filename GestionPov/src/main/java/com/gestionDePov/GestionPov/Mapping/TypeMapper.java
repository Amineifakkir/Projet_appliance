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


    @Autowired
    DozerBeanMapper dozerBeanMapper;

    //Entity To Dto

    public TypeDTO TypeToTypeDTO(Type tp){
         ;
    return dozerBeanMapper.map(tp,TypeDTO.class);
    }
//    Dto To Entity

    public Type TypeDTOToType(TypeDTO type){
        return dozerBeanMapper.map(type,Type.class);

}

//List Dto To List Entity

    public List<Type> ListTypeDTOToEntityType(List<TypeDTO> type){

        List<Type> LstTypeDto = new ArrayList<>();
        type.forEach(typeDTO -> LstTypeDto.add(TypeDTOToType(typeDTO)));
        return LstTypeDto;

    }

    //List Entity To List DTO

    public List<TypeDTO> ListEntityTypeToListType(List<Type> type){

        List<TypeDTO> LstType = new ArrayList<>();
        type.forEach(Entitytype -> LstType.add(TypeToTypeDTO(Entitytype)));
        return LstType;

    }

}
