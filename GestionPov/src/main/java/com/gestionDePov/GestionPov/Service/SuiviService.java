package com.gestionDePov.GestionPov.Service;

import com.gestionDePov.GestionPov.DTO.SuiviDTO;

import org.springframework.stereotype.Service;


import java.util.List;


public interface SuiviService {
    SuiviDTO save(SuiviDTO suivi);

    void delete(Long suivi);

    List<SuiviDTO> findAll();

    SuiviDTO Update(Long type, SuiviDTO suiviDTO);
}
