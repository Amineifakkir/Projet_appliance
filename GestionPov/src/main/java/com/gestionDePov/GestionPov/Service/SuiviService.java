package com.gestionDePov.GestionPov.Service;

import com.gestionDePov.GestionPov.DTO.SuiviDTO;

import com.gestionDePov.GestionPov.DTO.SuiviPageDTO;
import com.gestionDePov.GestionPov.DTO.TypePrestationDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;


public interface SuiviService {
    SuiviDTO save(SuiviDTO suivi);

    void delete(Long suivi);

   SuiviPageDTO findAll(Pageable pageRequest);
    List<SuiviDTO> findAll();
    SuiviDTO Update(Long type, SuiviDTO suiviDTO);
}
