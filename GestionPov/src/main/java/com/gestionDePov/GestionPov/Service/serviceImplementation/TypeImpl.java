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

@Service
public class TypeImpl implements TypeService {
    @Autowired
    TypeRepo typeRepo;
    @Autowired
    TypeMapper typeMapper;

    @Override
    public TypeDTO save(TypeDTO typedto) {
       return typeMapper.TypeToTypeDTO(typeRepo.save(typeMapper.TypeDTOToType(typedto)));

    }

    @Override
    public void delete(Long idType) {
        boolean exists =typeRepo.existsById(idType);
        if (!exists){
            throw new IllegalStateException(
                    "Type with id "+ idType +" does not exists");

        }

        typeRepo.deleteById(idType);

    }
//    @Override
//    public List<TypeDTO> findAll(TypeDTO typeDTO){
//     List<TypeDTO> LstType = new ArrayList<>();
//        return typeMapper.ListEntityTypeToEntityType(typeRepo.findAll(typeMapper.ListTypeDTOToEntityType(LstType)));
//    }
}
