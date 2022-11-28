package com.gestionDePov.GestionPov.Service;

import com.gestionDePov.GestionPov.DTO.SuiviDTO;

import com.gestionDePov.GestionPov.DTO.SuiviPageDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;


public interface SuiviService {
    SuiviDTO save(SuiviDTO suivi);

    void delete(Long suivi);

   SuiviPageDTO findAll(Pageable pageRequest);

    SuiviDTO Update(Long type, SuiviDTO suiviDTO);
}
