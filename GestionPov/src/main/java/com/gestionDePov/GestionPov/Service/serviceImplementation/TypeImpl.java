package com.gestionDePov.GestionPov.Service.serviceImplementation;

import com.gestionDePov.GestionPov.DTO.TypeDTO;
import com.gestionDePov.GestionPov.Mapping.TypeMapper;
import com.gestionDePov.GestionPov.Model.Type;
import com.gestionDePov.GestionPov.Repository.TypeRepo;
import com.gestionDePov.GestionPov.Service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public class TypeImpl implements TypeService {
    @Autowired
    TypeRepo typeRepo;
    @Autowired
    TypeMapper typeMapper;
//adding another line int DataBase
    @Override
    public TypeDTO save(TypeDTO typedto) {
       return typeMapper.TypeToTypeDTO(typeRepo.save(typeMapper.TypeDTOToType(typedto)));

    }
//Deleting a existing Line In the database
    @Override
    public void delete(Long idType) {
        boolean exists =typeRepo.existsById(idType);
        if (!exists){
            throw new IllegalStateException(
                    "Type with id "+ idType +" does not exists");

        }

        typeRepo.deleteById(idType);

    }

    @Override
    public List<TypeDTO> findAllType() {

        return typeMapper.ListEntityTypeToEntityType(typeRepo.findAll());

    }

    @Override
    public TypeDTO Update(Long type,TypeDTO typeDTO) {
        boolean exists =typeRepo.existsById(type);
        if (exists){
          save(typeDTO);

        }

   return typeDTO;
    }

}
