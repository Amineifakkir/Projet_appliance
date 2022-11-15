package com.gestionDePov.GestionPov.Service;


import com.gestionDePov.GestionPov.DTO.TypePrestationDTO;
import org.springframework.stereotype.Service;


import java.util.List;
@Service

public interface TypePrestationService {
    TypePrestationDTO save(TypePrestationDTO typePrestation);

    void delete(Long type);

   List<TypePrestationDTO> findAlltype();
    TypePrestationDTO Update(Long type, TypePrestationDTO typeDTO);

    //Update is Delete with Insert in BD or check if id exist 1
}
