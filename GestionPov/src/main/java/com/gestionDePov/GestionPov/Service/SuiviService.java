package com.gestionDePov.GestionPov.Service;

import com.gestionDePov.GestionPov.DTO.SuiviDTO;


import java.util.List;

public interface SuiviService {
    SuiviDTO save(SuiviDTO suivi);

    void delete(Long suivi);

    List<SuiviDTO> findAll();
}
