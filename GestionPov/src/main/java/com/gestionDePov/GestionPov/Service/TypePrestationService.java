package com.gestionDePov.GestionPov.Service;

import com.gestionDePov.GestionPov.DTO.TypePrestationDTO;


import java.util.List;

public interface TypePrestationService {
    TypePrestationDTO save(TypePrestationDTO typePrestation);

    void delete(Long type);

   List<TypePrestationDTO> findAlltype();

//    List<TypePrestationDTO> findAll(List<TypePrestationDTO> typePrestationDTOS);

    //Update is Delete with Insert in BD or check if id exist 1
}
