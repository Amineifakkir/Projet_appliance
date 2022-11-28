package com.gestionDePov.GestionPov.Service;


import com.gestionDePov.GestionPov.DTO.TypePrestationDTO;
import com.gestionDePov.GestionPov.DTO.TypePrestationPageDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;


public interface TypePrestationService {
    TypePrestationDTO save(TypePrestationDTO typePrestation);

    void delete(Long type);

   TypePrestationPageDTO findAlltype(Pageable pageRequest);
    TypePrestationDTO Update(Long type, TypePrestationDTO typeDTO);

    //Update is Delete with Insert in BD or check if id exist 1
}
