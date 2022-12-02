package com.gestionDePov.GestionPov.Service.serviceImplementation;

import com.gestionDePov.GestionPov.DTO.SuiviPageDTO;
import com.gestionDePov.GestionPov.DTO.TypeDTO;
import com.gestionDePov.GestionPov.DTO.TypePageDTO;
import com.gestionDePov.GestionPov.Mapping.TypeMapper;
import com.gestionDePov.GestionPov.Model.Suivi;
import com.gestionDePov.GestionPov.Model.Type;
import com.gestionDePov.GestionPov.Repository.TypeRepo;
import com.gestionDePov.GestionPov.Service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeImpl implements TypeService {
    @Autowired
    TypeRepo typeRepo;
@Autowired
    TypeMapper typeMapper;
//adding another line int DataBase
    @Override
    public TypeDTO save(TypeDTO typedto) {
       return typeMapper.TypeToTypeDTO(
               typeRepo.save(
                       typeMapper.TypeDTOToType(typedto)
               )
       );

    }
//Deleting an existing Line In the database
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
    public TypePageDTO findAllType(Pageable pageRequest){

        Page<Type> data =  typeRepo.findAll(pageRequest);
        TypePageDTO typePageDto = new  TypePageDTO();
        typePageDto.setTotalItems(data.getTotalElements());
        typePageDto.setPages(typeMapper.ListEntityTypeToListType(data.getContent()));

        return typePageDto;

    }

    @Override
    public List<TypeDTO> findAll() {
        return typeMapper.ListEntityTypeToListType(typeRepo.findAll());
    }

    @Override
    public TypeDTO Update(Long type,TypeDTO typeDTO) {
        boolean exists =typeRepo.existsById(type);
        if (exists){
            typeDTO.setIdType(type);
            typeRepo.save(typeMapper.TypeDTOToType(typeDTO));

        }

   return typeDTO;
    }

}
