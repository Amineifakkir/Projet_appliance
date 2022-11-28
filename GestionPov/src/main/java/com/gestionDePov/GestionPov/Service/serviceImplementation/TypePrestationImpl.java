package com.gestionDePov.GestionPov.Service.serviceImplementation;


import com.gestionDePov.GestionPov.DTO.TypePrestationDTO;
import com.gestionDePov.GestionPov.DTO.TypePrestationPageDTO;
import com.gestionDePov.GestionPov.Mapping.TypePrestationMapper;

import com.gestionDePov.GestionPov.Model.TypePrestation;
import com.gestionDePov.GestionPov.Repository.TypePrestationRepo;
import com.gestionDePov.GestionPov.Service.TypePrestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class TypePrestationImpl implements TypePrestationService {
    @Autowired
    TypePrestationRepo typePrestationRepo;
    @Autowired
    TypePrestationMapper typePrestationMapper;
    @Override
    public TypePrestationDTO save(TypePrestationDTO typePrestation) {
        return typePrestationMapper.TypeToTypeDTO(typePrestationRepo.save(typePrestationMapper.TypeDTOToType(typePrestation)));
//         typePrestationRepo.save(typePrestation);
    }

    @Override
    public void delete(Long type) {
        boolean exists =typePrestationRepo.existsById(type);
        if (!exists){
            throw new IllegalStateException(
                    "Type with id "+type+" does not exists");
    }
        typePrestationRepo.deleteById(type);

    }

    @Override
    public TypePrestationPageDTO findAlltype(Pageable pageRequest) {


        Page<TypePrestation> data =  typePrestationRepo.findAll(pageRequest);
        TypePrestationPageDTO typePrestationPageDto = new  TypePrestationPageDTO();
        typePrestationPageDto.setTotalItems(data.getTotalElements());
        typePrestationPageDto.setPages(typePrestationMapper.ListTypeDTOToEntityType(data.getContent()));

        return typePrestationPageDto;    }

    @Override
    public TypePrestationDTO Update(Long type, TypePrestationDTO typeDTO) {
        boolean exists = typePrestationRepo.existsById(type);
        if (exists) {
            typeDTO.setIdTypePres(type);
            typePrestationRepo.save(typePrestationMapper.TypeDTOToType(typeDTO));

        }


        return typeDTO;
    }
}