package com.gestionDePov.GestionPov.Service;

import com.gestionDePov.GestionPov.DTO.SuiviDTO;
import com.gestionDePov.GestionPov.DTO.TypePrestationDTO;


import java.util.List;

public interface SuiviService {
    SuiviDTO save(SuiviDTO suivi);

    void delete(Long suivi);

    List<SuiviDTO> findAll();

    SuiviDTO Update(Long type, SuiviDTO suiviDTO);
}
