package com.gestionDePov.GestionPov.Service.serviceImplementation;

import com.gestionDePov.GestionPov.DTO.TypePrestationDTO;
import com.gestionDePov.GestionPov.Mapping.TypePrestationMapper;
import com.gestionDePov.GestionPov.Model.TypePrestation;
import com.gestionDePov.GestionPov.Repository.TypePrestationRepo;
import com.gestionDePov.GestionPov.Service.TypePrestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<TypePrestation> findAll() {
        return typePrestationRepo.findAll();
    }
}
